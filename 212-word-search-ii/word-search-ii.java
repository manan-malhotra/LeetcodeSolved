class Solution {

    private TrieNode root = new TrieNode();
    private HashSet<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        addWordToTrie(words);

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                TrieNode node = root;

                recursiveSearch(board, node, i, j);
            }
        }
        return new ArrayList<>(result);
    }

    private void recursiveSearch(char[][] board, TrieNode node, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }


        
        if (node.children.containsKey(board[row][col])) {
            char currChar = board[row][col];
            TrieNode currNode = node.children.get(currChar);

            if (currNode.isWord()) {
                result.add(currNode.getWord());
            }
            board[row][col] = '#';
            recursiveSearch(board, currNode, row - 1, col);
            recursiveSearch(board, currNode, row + 1, col);
            recursiveSearch(board, currNode, row, col - 1);
            recursiveSearch(board, currNode, row, col + 1);
            board[row][col] = currChar;

            if (currNode.children.isEmpty()) {
                node.children.remove(board[row][col]);
            }
        }
        

        

        return;
    }

    private void addWordToTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.children.containsKey(word.charAt(i))) {
                    node.children.put(word.charAt(i), new TrieNode());
                } 
                node = node.children.get(word.charAt(i));
            }
            node.setWord(word);
        }
    }

    private class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word;

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return this.word;
        }

        public boolean isWord() {
            return this.word != null;
        }
    }
}