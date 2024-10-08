class Solution {
    public int[] answerQueries(int[] arr, int[] q) {
        int n = arr.length;
        Arrays.sort(arr);
        int pre[] = new int[n];
        pre[0] = arr[0];

        for(int i=1; i<n; i++){
            pre[i] = arr[i]+pre[i-1];
        }
        int ans[] = new int[q.length];

        for(int i=0; i<q.length; i++){
            int x=0;
            for(int j=0; j<n; j++){
                if(q[i]>=pre[j]) x++;
                else break;
            }
            ans[i] = x;
        }
        return ans;
    }
}