import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);  //
        
        int start = 1;  
        int end = (position[position.length - 1] - position[0]) / (m - 1);  
        
        
        while (start <= end) {
            int mid = (end + start) / 2;  
            if (canPlaceBalls(position, mid, m)) {
                start = mid + 1;  
            } else {
                end = mid - 1;  
            }
        }
        
        return end;  
    }
    
    
    private boolean canPlaceBalls(int[] position, int mid, int m) {
        int count = 1;  
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= mid) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;  
                }
            }
        }
        
        return false;  
    }
}