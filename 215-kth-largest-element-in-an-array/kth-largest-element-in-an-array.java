class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        for(int i:nums){
            pq.offer(i);
        }
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }
}