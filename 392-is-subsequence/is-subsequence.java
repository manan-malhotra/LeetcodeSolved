class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = s.length();
        if(s.length()==0){
            return true;
        }
        System.out.println(i);
        int j = t.length();
        while(i>0&&j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                i--;
                j--;
            }else{
                j--;
            }
        }
        if(i==0) return true;
        return false;
    }
}