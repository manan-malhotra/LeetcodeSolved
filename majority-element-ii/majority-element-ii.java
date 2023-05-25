class Solution {
    public List<Integer> majorityElement(int[] arr) {
         int count1 = 0;
        int count2 = 0;
        int ele1 = -1;
        int ele2 = -1;
        for(int i: arr){
            if(ele1==i){
                count1++;
            }else if(ele2 == i){
                count2++;
            }else if(count1==0){
                ele1 = i;
                count1++;
            }else if(count2==0){
                ele2=i;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i:arr){
            if(i==ele1) count1++;
            else if(i==ele2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>arr.length/3) ans.add(ele1);
        if(count2>arr.length/3) ans.add(ele2);
        return ans;
    }
}