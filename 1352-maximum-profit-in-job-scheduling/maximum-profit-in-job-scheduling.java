class Solution {
    /**
     * Calculates the maximum profit that can be obtained by scheduling jobs without overlapping time ranges.
     *
     * @param startTime An array representing the start times of jobs.
     * @param endTime   An array representing the end times of jobs.
     * @param profit    An array representing the profit associated with each job.
     * @return The maximum profit achievable without overlapping time ranges.
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Get the number of jobs
        int n = profit.length;

        // Create a 2D array 'jobs' to store information about each job
        int[][] jobs = new int[n][3];

        // Populate 'jobs' with start times, end times, and profits
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // Sort 'jobs' based on end times in ascending order
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        // Use a TreeMap to store the dynamic programming states (end time -> maximum profit)
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);  // Initialize the TreeMap with a key-value pair representing no jobs scheduled

        // Iterate through the sorted jobs to find the optimal schedule
        for (int[] job : jobs) {
            // Calculate the current profit by adding the current job's profit to the maximum profit until the end time of the previous job
            int currentProfit = treeMap.floorEntry(job[0]).getValue() + job[2];

            // Check if the current profit is greater than the maximum profit obtained so far
            if (currentProfit > treeMap.lastEntry().getValue()) {
                // Update the TreeMap with a new key-value pair representing the end time of the current job and the maximum profit achievable
                treeMap.put(job[1], currentProfit);
            }
        }

        // Return the maximum profit achievable by considering all jobs
        return treeMap.lastEntry().getValue();
    }
}