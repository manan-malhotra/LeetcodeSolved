class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1) return 0;
        Map<Integer,List<Integer>> manages = new HashMap<>();
        for(int i=0;i<n;i++){
            int currManager = manager[i];
            if(currManager==-1) continue;
            if(!manages.containsKey(currManager)){
                manages.put(currManager,new ArrayList<>());
            }
            manages.get(currManager).add(i);
        }
        return getMaxMinutes(headID,manages,informTime);
    }
    public int getMaxMinutes(int headID, Map<Integer,List<Integer>> manages,int[] informTime){
        if(!manages.containsKey(headID)) return 0;
        List<Integer> employees = manages.get(headID);
        int totalTime = Integer.MIN_VALUE;
        for(int emp:employees){
            totalTime = Math.max(totalTime, getMaxMinutes(emp,manages,informTime));
        }
        return totalTime + informTime[headID];
    }
}