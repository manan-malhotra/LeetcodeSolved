class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int start = height[left];
            int end = height[right];
            int min = Math.min(start,end);
            int dist = right-left;
            int currArea = min * dist;
            maxArea = Math.max(currArea,maxArea);
            if(start>end){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}