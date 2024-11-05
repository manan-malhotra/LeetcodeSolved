class CustomStack {

    int index;
    int size;
    int[] arr;
    public CustomStack(int maxSize) {
        index = 0;
        size = maxSize;
        arr = new int[size];
    }
    
    public void push(int x) {
        if(index<size) {
            arr[index++] = x;
        }
    }
    
    public int pop() {
        if(index==0) return -1;
        return arr[--index];
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k && i<index; i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */