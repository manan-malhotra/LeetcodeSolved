class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();

        for (char val : s.toCharArray()) { 
            if (stack.isEmpty()) {
                stack.push(val); 
            } 
            else if (stack.peek() == '[' && val == ']') {
                stack.pop();
            } 
            else {
                stack.push(val); 
            }
        }

        if (stack.size() == 2) {
            return 1;
        }

        int single = stack.size() / 2;

        return (int)Math.ceil((double)single / 2);
    }
}