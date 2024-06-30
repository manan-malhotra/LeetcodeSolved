class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    arr[j]+=1;
                }else{
                    arr[j] = 0;
                }
            }
            ans = Math.max(ans,histogram(arr));
        }
        return ans;
    }
    public int histogram(int[] arr){
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