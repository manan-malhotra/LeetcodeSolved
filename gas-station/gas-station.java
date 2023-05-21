class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diffOfSum = 0;
        int surplus = 0;
        int start = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            diffOfSum += gas[i]-cost[i];
            surplus += gas[i]-cost[i];
            if(surplus<0){
                surplus = 0;
                start = i+1;
            }
        }
        if(diffOfSum<0) return -1;
        return start;

    }
}