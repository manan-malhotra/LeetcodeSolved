class Solution {
    public int jump(int[] nums) {
        int jumps = 0; // Number of jumps taken
        int curMaxReach = 0; // Farthest reachable index with current number of jumps
        int nextMaxReach = 0; // Farthest reachable index with one more jump
        
        for (int i = 0; i < nums.length - 1; ++i) {
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);

            // If we finish the current jump range, move on to the next one
            if (i == curMaxReach) {
                jumps++;
                curMaxReach = nextMaxReach;
            }
        }
        
        return jumps;
    }
}