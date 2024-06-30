class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxAns = 0;
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || arr[st.peek()]>=arr[i])){
                int height = arr[st.pop()];
                int width = i;
                if(!st.isEmpty()) width = i - st.peek() - 1;
                maxAns = Math.max(height*width, maxAns); 
            }
            st.push(i);
        }
        return maxAns;
    }
}