class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int ele1=-1;
        int ele2=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }            
            else if(count1==0){
                ele1=nums[i];
                count1++;
            }else if(count2==0){
                ele2=nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                count1++;
            }else if(nums[i]==ele2){
                count2++;
            }
        }
        // System.out.println(ele1);
        // System.out.println(ele2);
        // System.out.println(count1);
        // System.out.println(count2);

        if(count1>nums.length/3){
            arr.add(ele1);
        }if(count2>nums.length/3){
            arr.add(ele2);
        }

        return arr;
    }
}