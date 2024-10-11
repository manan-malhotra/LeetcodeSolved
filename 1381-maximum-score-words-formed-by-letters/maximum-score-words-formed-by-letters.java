class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int [] frequency = new int[26];
        for(int i = 0;i<letters.length;i++){
            frequency[letters[i]-'a']++;
        }
        int result = backtrack(words,frequency,score,0);
        return result;
        
        
    }
    public static int backtrack(String[] words, int[] frr, int[] score,int idx){
        if(idx == words.length){
            return 0;
        }
        int scoreOfaWord =0;
        int no = backtrack(words,frr,score,idx+1);
        boolean isValid = true;
        for(int i =0;i<words[idx].length();i++){
            char ch = words[idx].charAt(i);
            if(frr[ch-'a']<=0){
                isValid = false;
            }
            frr[ch-'a']--;
            scoreOfaWord += score[ch-'a'];
            
        }
        int yes =0;
        if(isValid){
            yes = scoreOfaWord + backtrack(words,frr,score,idx+1);
        }
        for(int i =0;i<words[idx].length();i++){
            frr[words[idx].charAt(i)-'a']++;
        }
        return Math.max(no,yes);
        
        
    }
}