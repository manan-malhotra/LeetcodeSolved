class WordDictionary {
    // implement a prefix tree again
    private static final int ALPHABET_SIZE = 26;
    private TrieNode root = new TrieNode();

    private class TrieNode {
        private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isWordEnd = false;

        private TrieNode() {

        }
    }

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        // add word to trie char by char
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cI = (int)c - (int)'a';
            if (curr.children[cI] == null) {
                curr.children[cI] = new TrieNode();
            }
            curr = curr.children[cI];
        }
        curr.isWordEnd = true;
    }
    
    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    private boolean search(String word, TrieNode root, int j) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && search(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int cI = (int)c - (int)'a';
                if (curr.children[cI] == null) {
                    return false;
                }
                curr = curr.children[cI]; 
            }
        }
        return curr != null && curr.isWordEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */