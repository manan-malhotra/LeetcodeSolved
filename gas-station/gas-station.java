class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int surplusGas = 0;
        int startFrom = 0;
        for(int i=0;i<gas.length;i++){
            totalCost += gas[i]-cost[i];
            surplusGas += gas[i]-cost[i];

            if(surplusGas < 0){
                startFrom = i+1;
                surplusGas = 0;
            }
        }
        if(totalCost>=0) return startFrom;
        return -1;

    }
}