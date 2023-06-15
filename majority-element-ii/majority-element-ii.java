class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int ele1 = 0;
        int ele2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<arr.length;i++){
            if(ele1==arr[i]){
                count1++;
            }else if(ele2 == arr[i]){
                count2++;
            }else if(count1 == 0){
                ele1 = arr[i];
                count1=1;
            }else if(count2 == 0){
                ele2 = arr[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i: arr){
            if(i==ele1){
                count1++;
            }
            else if(i==ele2){
                count2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>arr.length/3) ans.add(ele1);
        if(count2>arr.length/3) ans.add(ele2);
        return ans;
    }
}