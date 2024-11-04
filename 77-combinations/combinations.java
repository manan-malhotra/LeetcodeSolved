class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        solve(1,0,k,n);
        return ans;
    }
    public void solve(int i, int j, int k, int n){
        if(j==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int num=i;num<=n;num++){
            temp.add(num);
            solve(num+1,j+1,k,n);
            temp.remove(temp.size()-1);
        }
    }
}