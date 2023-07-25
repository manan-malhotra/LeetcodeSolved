class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int count = 0;
        for(char i:s.toCharArray()){
            if(i=='(' || i=='[' || i=='{'){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    count++;
                }else{

                char check = stack.pop();
                if(check=='(' && i!=')') count++;
                else if(check=='[' && i!=']') count++;
                else if(check=='{' && i!='}') count++;
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
            return count;
    }
}