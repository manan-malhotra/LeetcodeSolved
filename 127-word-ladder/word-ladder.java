class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            if(word==beginWord) continue;
            set.add(word);
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.remove();
                // System.out.println(word);
                if(word.equals(endWord)) return distance;
                for(int j=0;j<word.length();j++){
                char[] charArray = word.toCharArray();
                    for(char ch = 'a'; ch<='z';ch++){
                        charArray[j] = ch;
                        String newWord = new String(charArray);
                        if(set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}