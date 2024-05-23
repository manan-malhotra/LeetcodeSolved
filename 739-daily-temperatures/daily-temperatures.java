class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temp[st.peek()]<temp[i]){
                int t = st.pop();
                ans[t] = i-t;
            }
            st.push(i);
            // System.out()
        }
        return ans;
    }
}