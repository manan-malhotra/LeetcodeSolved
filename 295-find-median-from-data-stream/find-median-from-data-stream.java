class MedianFinder {
    PriorityQueue<Integer> mx = new PriorityQueue<>((val1,val2)->val2-val1);
    PriorityQueue<Integer> mn = new PriorityQueue<>();

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if((mn.size()+mx.size())%2 == 0){
            if(!mn.isEmpty() && num>mn.peek()){
                mn.add(num);
                mx.add(mn.poll());
            }
            else
            mx.add(num);
        }
        else{
            if(num<mx.peek()){
                mx.add(num);
                mn.add(mx.poll());
            }
            else
            mn.add(num);
        }
    }
    
    public double findMedian() {
        if(!mx.isEmpty()){
            if((mn.size()+mx.size())%2 == 0){
                return (double)(mn.peek()+mx.peek())/2.0;
            }
            else
            return (double)mx.peek();
        }
        return 0.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */