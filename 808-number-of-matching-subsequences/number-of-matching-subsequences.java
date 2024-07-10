class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        char[] str = s.toCharArray();
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String word:map.keySet()){
            if(isSubsequence(str,word.toCharArray())) count+= map.get(word);
        }
        return count;
    }
    public boolean isSubsequence(char[] s, char[] word){
        int n = s.length;
        int m = word.length;
        if(m>n) return false;
        int i=0, j=0;
        while(j!=m && i!=n){
            if(s[i]==word[j]){
                j++;
            }
            i++;
        }
        return j==m;
    }
}