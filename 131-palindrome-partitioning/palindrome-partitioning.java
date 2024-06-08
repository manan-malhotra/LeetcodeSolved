class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(ans,new ArrayList<>(), s, 0);
        return ans;   
    }
    public void solve(List<List<String>> ans, List<String> temp, String s,int index){
        if(index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                solve(ans,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}