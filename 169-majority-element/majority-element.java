class Solution {
    public int majorityElement(int[] nums) {
        int possible = 0 ;
        int count = 0 ;
        for(int num : nums){
            if(count==0){
                possible=num;
                count++;
            }else{
                if(possible==num){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return possible;
    }
}