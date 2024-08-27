class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        int window = 0;
        if(k>0){
            for(int i = 1; i <= k; i++){
                window+=code[i%n];
            }
            for(int i=0;i<n;i++){
                ans[i] = window;
                window -= code[(i+1)%n];
                window += code[(i+1+k)%n];
            }
        }else if(k<0){
            for(int i=k;i<0;i++){
                window += code[(n+i)%n];
            }
            for(int i= 0;i<n;i++){
                ans[i] = window;
                window -= code[(n+i+k)%n];
                window += code[i%n];
            }
        }   
        return ans;
    }
}