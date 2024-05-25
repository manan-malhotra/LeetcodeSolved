class FreqStack {
    private final Map<Integer, Stack<Integer>> stacks;
    private final Map<Integer, Integer> frequencies;
    private int maxFrequency;

    public FreqStack() {
        this.stacks = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.maxFrequency = 0;
    }
    
    public void push(final int val) {
        final int frequency = frequencies.getOrDefault(val, 0) + 1;

        this.maxFrequency = Math.max(frequency, this.maxFrequency);

        frequencies.put(val, frequency);

        this.stacks.putIfAbsent(frequency, new Stack<>());
        this.stacks.get(frequency).add(val);
    }
    
    public int pop() {
        final Stack<Integer> stack = this.stacks.get(this.maxFrequency);
        final int val = stack.pop();

        if(stack.isEmpty())
            this.stacks.remove(this.maxFrequency--);

        final int frequency = this.frequencies.get(val);

        this.frequencies.put(val, frequency - 1);

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */