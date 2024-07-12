class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();
        prev[0] = -1;
        stack.add(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prev[i] = -1;
            }else{
                prev[i] = stack.peek();
            }
            stack.push(i);
        }
        next[n-1] = n;
        while(!stack.isEmpty()) stack.pop();
        stack.add(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                next[i] = n;
            }else{
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            System.out.print(next[i]+" ");
            ans = Math.max(ans, heights[i]*(next[i]-prev[i]-1));
        }
        return ans;
    }
}