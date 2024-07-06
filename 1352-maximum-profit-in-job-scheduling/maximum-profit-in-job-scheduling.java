class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = profit.length;
        
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));
        
        int[] dp = new int[len];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < len; i++) {
            int start = jobs[i].start;
            int left = 0;
            int right = i - 1;
            int res = -1;
            
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (jobs[mid].end <= start) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            int doCurJob = jobs[i].profit;
            if (res != -1) {
                doCurJob += dp[res];
            }
            
            int notDoCurJob = dp[i - 1];
            
            dp[i] = Math.max(doCurJob, notDoCurJob);
        }
        
        return dp[len - 1];
    }
}

class Job {
    int start;
    int end;
    int profit;
    
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}