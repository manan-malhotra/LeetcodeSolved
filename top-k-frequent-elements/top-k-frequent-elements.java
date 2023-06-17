class Solution {
    public int[] topKFrequent(int[] num, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[num.length+1];
        for(int n: num){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int value : bucket[i]){
                    res[index++]=value;
                    System.out.println(value + "val");
                }
            }

        }
        return res;
    }
}