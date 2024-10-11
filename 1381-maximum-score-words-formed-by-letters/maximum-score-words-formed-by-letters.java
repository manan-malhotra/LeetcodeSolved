class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnts = new int[128];
        for(char c: letters) {
            cnts[c]++;
        }
        return helper(score, words, 0, cnts);
    }

    int helper(int[] score, String[] words, int idx, int[] cnts) {
        if(idx == words.length) return 0;
        int skip = helper(score, words, idx + 1, cnts);
        boolean canUse = true;
        var w = words[idx];
        int use = 0;
        for(int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if(--cnts[c] < 0) canUse = false;
            use += score[c - 'a'];
        }
        if(canUse) {
            use += helper(score, words, idx + 1, cnts);
        }
        for(int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            ++cnts[c];
        }
        return canUse ? Math.max(use, skip) : skip;
    }
}