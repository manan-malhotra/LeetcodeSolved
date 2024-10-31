class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int i=0;
        int j = n-1;
        while(i<j){
            ans = Math.max(ans,(j-i)*Math.min(arr[i],arr[j]));
            if(arr[i]<arr[j]) i++;
            else j--;
        }
        return ans;
    }
}