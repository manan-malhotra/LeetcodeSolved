public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length; // Get the number of children
        int upCount = 0, downCount = 0, peakCount = 0, totalCandies = 1; // Initialize variables
        
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                // If the current child has a higher rating than the previous one
                downCount = 0;
                upCount += 1;
                peakCount = upCount + 1;
                totalCandies += peakCount;
            } else if (ratings[i - 1] == ratings[i]) {
                // If the current child has the same rating as the previous one
                downCount = 0;
                upCount = 0;
                peakCount = 0;
                totalCandies += 1;
            } else {
                // If the current child has a lower rating than the previous one
                downCount += 1;
                upCount = 0;
                totalCandies += downCount + 1 - (peakCount > downCount ? 1 : 0);
            }
        }
        
        return totalCandies;
    }
}