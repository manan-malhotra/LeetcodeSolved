class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i:asteroids){
            while(!stack.isEmpty() && i<0 && stack.peek()>0){
                int peek = stack.pop();
                int compare = i*-1;
                if(peek>compare){
                    i=peek;
                }
                if(compare==peek) i=0;
            }
            if(i!=0) stack.push(i);
        }
        int n = stack.size();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}