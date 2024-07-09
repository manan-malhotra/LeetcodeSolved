class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0;
        int j=0;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        boolean isRepeated = false;
        while(i!=n){
            char curr = s.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
            if(map.get(curr)>1) isRepeated = true;
            while(isRepeated){
                char prev = s.charAt(j);
                map.put(prev,map.get(prev)-1);
                j++;
                if(map.get(prev)==1) isRepeated = false;
            }
            count = Math.max(i-j+1,count);
            i++;
        }
        return count;
    }
}