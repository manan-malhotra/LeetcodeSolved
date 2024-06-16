class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord))
            return 0;

        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Set<String> words = new HashSet<>();
        for(String word:wordList){
            if(word.equals(beginWord)) continue;
            words.add(word);
        }
        queue.offer(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            String newWord = queue.peek().getKey();
            int step = queue.poll().getValue();
           
            for(int i=0;i<newWord.length();i++){
                char[] newWordArray = newWord.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    newWordArray[i] = ch;
                    String word = new String(newWordArray);
                    if(words.contains(word)){
                        if(word.equals(endWord)) return step+1;
                        words.remove(word);
                        queue.offer(new Pair(word,step+1));
                    }
                }
            }
        }
        return 0;
    }

}