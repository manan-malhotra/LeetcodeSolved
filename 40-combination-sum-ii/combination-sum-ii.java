class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList<>();
        findAns(0,candidates, target,ans,temp);
        return ans;
    }

    public void findAns(int index,int[] candidates, int target,List<List<Integer>> ans,List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            temp.add(candidates[i]);
            findAns(i+1,candidates, target-candidates[i],ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}