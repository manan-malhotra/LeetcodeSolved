class Solution {
    public int missingNumber(int[] nums) { //binary search
    int n = nums.length;
    int actSum = (n*(n+1))/2;
System.out.println(actSum);
   
   for(int i:nums) actSum-=i;
   
   return actSum;
}
}