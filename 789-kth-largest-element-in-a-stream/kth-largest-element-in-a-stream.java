
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);

        // Add all elements from nums to the heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add the new value to the heap
        minHeap.offer(val);
        if (minHeap.size()>k)minHeap.poll();     
        return minHeap.peek();
    }
}