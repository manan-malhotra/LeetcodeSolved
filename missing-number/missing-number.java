class Solution {
    public int missingNumber(int[] nums) { //binary search
    int n = nums.length;
    int actSum = (n*(n+1))/2;
System.out.println(actSum);
   int sum = 0;
   for(int i:nums) sum+=i;
   System.out.println(sum);
   return actSum-sum;
}
}