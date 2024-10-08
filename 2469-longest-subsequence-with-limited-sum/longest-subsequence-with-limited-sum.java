class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int maxs[] = new int[queries.length];
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }

        for(int i=0;i<queries.length;i++){
            int l=0;
            int r = nums.length-1;
            while(l<=r){
                int mid= l+ (r-l)/2;
                if(nums[mid]>queries[i]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            maxs[i]=r+1;
        }
        return maxs;
    }
}