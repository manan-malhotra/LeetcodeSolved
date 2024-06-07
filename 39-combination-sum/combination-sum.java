class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        rec(0,target,list,new ArrayList<>(),arr);
        return list;
    }

    public void rec(int i, int target, List<List<Integer>> list, List<Integer> temp, int[] arr){
        if(target==0){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(i==arr.length) return;
        if(target<0) return;
        rec(i+1,target,list,temp,arr);
        temp.add(arr[i]);
        rec(i,target-arr[i],list,temp,arr);
        temp.remove(temp.size()-1);
    }
}