class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        while(j!=s.length()){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j))+1);
            }
            ans=Math.max(ans,j-i+1);
            map.put(s.charAt(j),j++);
        }
        return ans;
    }
}