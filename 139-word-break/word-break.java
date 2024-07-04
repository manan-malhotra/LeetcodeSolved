class TrieNode {
    char character;
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(char c) {
        character = c;
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Solution {
    TrieNode root;

    public Solution() {
        root = new TrieNode('\0');
    }

    public void insertWord(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode(c);
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean canSegmentString(TrieNode root, String s, int start, int[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != -1) return memo[start] == 1;

        TrieNode currentNode = root;
        for (int i = start; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                memo[start] = 0;
                return false;
            }
            currentNode = currentNode.children[index];
            if (currentNode.isEndOfWord && canSegmentString(root, s, i + 1, memo)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            insertWord(root, word);
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return canSegmentString(root, s, 0, memo);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = Arrays.asList("leet", "code");
        String s = "leetcode";
        System.out.println(solution.wordBreak(s, wordDict)); // true
    }
}