class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            if(word==beginWord) continue;
            set.add(word);
        }
        if(!set.contains(endWord)) return 0;
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        int n = beginWord.length();
        while(!queue.isEmpty()){
            String word = queue.peek().getKey();
            int distance = queue.poll().getValue();
            for(int i=0;i<n;i++){
                char[] wordArr = word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    wordArr[i] = ch;
                    String newWord = new String(wordArr);
                    if(newWord.equals(endWord)) return distance+1;
                    if(set.contains(newWord)){
                        queue.add(new Pair(newWord, distance+1));
                        set.remove(newWord);
                    }
                }
            }   
        }
        return 0;
    }
}