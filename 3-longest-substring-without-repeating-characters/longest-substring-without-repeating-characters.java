class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int length = s.length();
        while(j!=length){
            Character currentChar = s.charAt(j);
            if(map.containsKey(currentChar)){
                i=Math.max(i,map.get(currentChar)+1);
            }
            ans=Math.max(ans,j-i+1);
            map.put(currentChar,j++);
        }
        return ans;
    }
}