class Solution {

    private int m;
    private int n;
    
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] sumMatrix = prepareSumMatrix(matrix);
        int count = 0;
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int x1 = 0; x1 < m; x1++) {
            countsMap.clear();
            for (int k1 = 0; x1 + k1 < m; k1++) {
                int x2 = x1 + k1;
                countsMap.clear();
                for (int y2 = 0; y2 < n; y2++) {
                    int currSum = matrixSumFor(sumMatrix, x1, 0, x2, y2);
                    if (currSum == target) {                        
                        count++;
                    }
                    count += countsMap.getOrDefault(currSum - target, 0);
                    countsMap.put(currSum, countsMap.getOrDefault(currSum, 0) + 1);
                }
            }
        }
        return count;
    }

    private int matrixSumFor(int[][] sumMatrix, int x1, int y1, int x2, int y2) {
        return sumMatrix[x2][y2] - (x1 == 0? 0 : sumMatrix[x1 - 1][y2]) - (y1 == 0? 0 : sumMatrix[x2][y1-1]) 
            + (x1 == 0 || y1 == 0 ? 0 : sumMatrix[x1-1][y1-1]);
    }

    private int[][] prepareSumMatrix(int[][] matrix) {
        int[][] sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        return sum;
    }
}