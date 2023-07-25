class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char i:s.toCharArray()){
            if(i=='(' || i=='[' || i=='{'){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char check = stack.pop();
                if(check=='(' && i!=')') return false;
                else if(check=='[' && i!=']') return false;
                else if(check=='{' && i!='}') return false;
            }
        }
            return stack.isEmpty();
    }   
}