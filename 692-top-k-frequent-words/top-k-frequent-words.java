class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Word> pq = new PriorityQueue<>((a, b)->{
                return a.freq != b.freq ? a.freq - b.freq : -a.s.compareTo(b.s);
            });
        for(String key : map.keySet()){
            Word word = new Word(key,map.get(key));
            pq.offer(word);
            if(pq.size()>k) pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Word word = pq.poll();
            ans.add(0,word.s);
        }
        return ans;
    }
}
class Word{
    String s;
    int freq;
    public Word(String s,int freq){
        this.s=s;
        this.freq=freq;
    }
}