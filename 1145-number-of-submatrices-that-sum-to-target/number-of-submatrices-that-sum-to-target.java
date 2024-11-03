class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int r = matrix.length, c = matrix[0].length;

    // compute 2D prefix sum
    int[][] prefixSum = new int[r + 1][c + 1];

    for (int i = 1; i < r + 1; i++) {
      for (int j = 1; j < c + 1; j++) {
        prefixSum[i][j] = (prefixSum[i - 1][j] + prefixSum[i][j - 1]) - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    int count = 0; 
    int currSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    // reduce 2D problem to 1D one
    // by fixing two rows r1 and r2 and 
    // computing 1D prefix sum for all matrices using [r1..r2] rows
    for (int r1 = 1; r1 < r + 1; ++r1) {
      for (int r2 = r1; r2 < r + 1; ++r2) {
        map.clear();
        map.put(0, 1);
        for (int col = 1; col < c + 1; ++col) {
          // current 1D prefix sum
          currSum = prefixSum[r2][col] - prefixSum[r1 - 1][col];

          // add subarrays which sum up to (currSum - target)
          count += map.getOrDefault(currSum - target, 0);

          // save current prefix sum
          map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
      }
    }

    return count;
  }
}