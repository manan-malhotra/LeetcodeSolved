class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int i:stones){
            pq.offer(i);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int rem = a-b;
            if(rem!=0) pq.offer(rem);
        }
        return pq.size()==0?pq.size():pq.poll();
    }
}