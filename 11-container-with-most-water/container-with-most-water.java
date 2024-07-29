class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            int dist = j-i;
            int min = Math.min(height[i],height[j]);
            max = Math.max(max,min*dist);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}