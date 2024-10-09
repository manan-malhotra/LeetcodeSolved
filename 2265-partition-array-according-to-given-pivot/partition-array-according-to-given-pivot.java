class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> greaterThan = new ArrayList<>();
        int[] ans = new int[n];
        int i = 0;
        int count = 0;
        for(int num: nums){
            if(num<pivot) ans[i++] = num;
            else if(num==pivot) count++;
            else greaterThan.add(num);
        }
        while(count!=0){
            count--;
            ans[i++] = pivot;
        }
        int j=0;
        while(i!=n){
            ans[i++] = greaterThan.get(j++);
        }
        return ans;
    }
}