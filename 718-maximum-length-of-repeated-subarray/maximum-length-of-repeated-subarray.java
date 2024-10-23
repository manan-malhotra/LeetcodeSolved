class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]) dp[i][j] = 1+dp[i-1][j-1];
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
    public void addToSet(int[] arr, HashSet<String> set){
        int n = arr.length;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n;j++){
                sb.append(arr[j]+",");
                set.add(sb.toString());
            }
        }
    }
    public int checkLength(int[] arr, HashSet<String> set){
        int n = arr.length;
        int len = 0;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n;j++){
                sb.append(arr[j]+",");
                if(set.contains(sb.toString())){
                    // System.out.println(sb.toString());
                    int currlen = j+1 - i;
                    len = Math.max(len,currlen);
                }else{
                    break;
                }
            }
        }
        return len;
    }
}