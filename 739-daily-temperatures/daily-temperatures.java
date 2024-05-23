class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int[] nextWarmerDay = new int[n];  // To store the index of the next warmer day for each day

        // Initialize nextWarmerDay array with a value indicating no warmer day found yet
        Arrays.fill(nextWarmerDay, Integer.MAX_VALUE);

        // Iterate from right to left to find the next warmer day for each day
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            // Move to the next warmer day if the temperature is greater
            while (j < n && temperatures[j] <= temperatures[i]) {
                j = nextWarmerDay[j];
            }
            // Update the nextWarmerDay for the current day
            if (j < n) {
                nextWarmerDay[i] = j;
            }
        }

        // Calculate the result using the nextWarmerDay information
        for (int i = 0; i < n; i++) {
            if (nextWarmerDay[i] != Integer.MAX_VALUE) {
                result[i] = nextWarmerDay[i] - i;
            }
        }

        return result;
    }
}