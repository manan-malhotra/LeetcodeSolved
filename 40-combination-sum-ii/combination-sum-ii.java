class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> al=new ArrayList<>();
        findAns(0,candidates, target,ans,al);
        return ans;
    }

    public void findAns(int index,int[] candidates, int target,List<List<Integer>> ans,List<Integer> al){
        if(target==0){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            al.add(candidates[i]);
            findAns(i+1,candidates, target-candidates[i],ans,al);
            al.remove(al.size()-1);
        }
    }
}