class Solution {
    public int trap(int[] A) {
        int n = A.length;
        int[] GFR = new int[n];
        int[] GFL = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && A[st.peek()]<A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                GFR[i] = -1;
                st.push(i);
            }else{
                GFR[i] = st.peek();
            }
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && A[st.peek()]<A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                GFL[i] = -1;
                st.push(i);
            }else{
                GFL[i] = st.peek();
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            if(GFR[i]!=-1 && GFL[i]!=-1){
                int min = Math.min(A[GFR[i]],A[GFL[i]]);
                sum+=min-A[i];
                
            }
        }
        return sum;
    }
}