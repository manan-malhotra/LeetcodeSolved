class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] temp = new int[n];
        Arrays.fill(temp,-1);
        int i = 0;
        for(int j=0;j<n;j++){
            if(i==0 && temp[0]==-1) temp[i] = arr[j];
            else if(temp[i]<=arr[j]){
                while(temp[i]!=-1 && temp[i]<=arr[j]) i++;
                temp[i] = arr[j];
            }else{
                while(i>=0 && temp[i]>arr[j]) i--;
                i++;
                temp[i] = arr[j];
            }
            ans[j] = i+1;
        }
        return ans;
    }
}