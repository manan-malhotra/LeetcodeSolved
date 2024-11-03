class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        
        for(int[] row : matrix){
            for(int col = 1; col < cols; col++){
                row[col] += row[col-1];
            }
        }
        
        int sumCnt = 0;
        
        for(int left = 0; left < cols; left++){
            for(int right = left; right < cols; right++){
                int currPrefSum = 0;
                Map<Integer, Integer> sumFreq = new HashMap<>();
                sumFreq.put(0, 1);
                
                for(int r = 0; r < rows; r++){
                    int prefSumCurrRow = matrix[r][right] - ((left - 1 > -1) ? matrix[r][left - 1] : 0);
                    currPrefSum += prefSumCurrRow;
                    if(sumFreq.containsKey(currPrefSum - target)){
                        sumCnt += sumFreq.get(currPrefSum - target);
                    }
                    sumFreq.put(currPrefSum, sumFreq.getOrDefault(currPrefSum, 0) + 1);
                }
            }
        }
        return sumCnt;
    }
}
