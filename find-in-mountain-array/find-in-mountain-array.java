/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return(findPeak(mountainArr,target));
    }
    public static int findPeak(MountainArray mountainArr, int target) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if (mountainArr.get(mid) > mountainArr.get(mid+1))
            end = mid;
            else 
            start = mid +1;
        }
        if(mountainArr.get(start) == target)
        return start;
        else{ 
        int ans = orderAgnosticBS(mountainArr, target, 0,start-1,true);
        if( ans != -1)
        return ans;
        else
        return(orderAgnosticBS(mountainArr, target, start+1,mountainArr.length()-1, false)) ;
        }
    }
    public static int orderAgnosticBS(MountainArray mountainArr,int target, int start,int end, boolean bool) {
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target)
            return mid;
            else {
                if(bool) {
                    if (mountainArr.get(mid) > target)
                    end = mid - 1;
                    else
                    start = mid + 1;
                }
                else {
                    if (mountainArr.get(mid) > target)
                    start = mid + 1;
                    else
                    end = mid-1;
                }
            }
        
        }
        return -1;
    }
}