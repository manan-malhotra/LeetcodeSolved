class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int num: nums) arr.add(num);
        Collections.sort(arr);
        for(int i = 0; i<len; i++){
            int index = binarySearch(arr,nums[i]);
            ans.add(index);
            //every time we are removing the element whose index is already found in sorted array
            arr.remove(index);
        }
        return ans;
    }
    // find the exact index of sorted array 
    int binarySearch(List<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;
        int mid=0;
        int res=0;
        while(start<=end){
            mid = start + ((end - start)/2);
            int val = arr.get(mid);
            if(val<target) start = mid + 1;
            else if(val==target)
            {
                end=mid-1;
                res=mid;
            }
            else end = mid - 1;
        }
        return res;
    }
}