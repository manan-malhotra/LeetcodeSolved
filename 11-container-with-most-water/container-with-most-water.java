class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int left = 0, right = n - 1;

        for (int i = 0; left < right; i++) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int curA = h * w;
            maxArea = Math.max(maxArea, curA);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}