class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        int leftCount = 0, rightCount = 0, leftOps = 0, rightOps = 0;

        for (int i = 0; i < n; i++) {
            result[i] = leftOps;
            if (boxes.charAt(i) == '1') {
                leftCount++;
            }
            leftOps += leftCount;
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] += rightOps;
            if (boxes.charAt(i) == '1') {
                rightCount++;
            }
            rightOps += rightCount;
        }

        return result;
    }
}