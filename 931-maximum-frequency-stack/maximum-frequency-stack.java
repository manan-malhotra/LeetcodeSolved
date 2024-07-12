class FreqStack {
    int maxFreq;
    HashMap<Integer,Integer> count;
    HashMap<Integer, List<Integer>> stack;
    public FreqStack() {
        maxFreq = 0;
        count = new HashMap<>();
        stack = new HashMap<>();
    }
    
    public void push(int val) {
        int currFreq = count.getOrDefault(val,0);
        int newFreq = currFreq + 1;
        count.put(val,newFreq);
        if(newFreq>maxFreq){
            maxFreq = newFreq;
            stack.put(maxFreq, new ArrayList<>());
        }
        stack.get(newFreq).add(val);
    }
    
    public int pop() {
        List<Integer> topFreq = stack.get(maxFreq);
        int topValue = topFreq.remove(topFreq.size()-1);
        if(topFreq.size()==0) maxFreq--;
        count.put(topValue,count.get(topValue)-1);
        return topValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */