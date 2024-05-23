class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i : tokens){
            if(i.equals("+") || i.equals("*") || i.equals("/") || i.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                if(i.equals("+")) stack.push(first+second);
                if(i.equals("-")) stack.push(first-second);
                if(i.equals("*")) stack.push(first*second);
                if(i.equals("/")) stack.push(first/second);
            }else{
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.pop();
        
    }
}