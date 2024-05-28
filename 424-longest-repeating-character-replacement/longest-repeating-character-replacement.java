class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j=0,ans=0,current=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j!=s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            current = Math.max(current,map.get(s.charAt(j)));
            if(j-i+1-current>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}