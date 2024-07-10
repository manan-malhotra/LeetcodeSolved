class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String word:map.keySet()){
            if(isSubsequence(s,word)) count+= map.get(word);
        }
        return count;
    }
    public boolean isSubsequence(String s, String word){
        int n = s.length();
        int m = word.length();
        if(m>n) return false;
        int i=0, j=0;
        while(j!=m && i!=n){
            if(s.charAt(i)==word.charAt(j)){
                j++;
            }
            i++;
        }
        return j==m;
    }
}