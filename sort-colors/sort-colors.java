class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int i:nums){
            if(i==0) z++;
            else if(i==1) o++;
            else if(i==2) t++;
        }
        int j = 0;
        while(z!=0){
            nums[j++]=0;
            z--;
        }
        while(o!=0){
            nums[j++]=1;
            o--;
        }
        while(t!=0){
            nums[j++]=2;
            t--;
        }
    }
}