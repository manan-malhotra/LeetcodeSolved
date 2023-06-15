class Solution {
    public int findMaxLength(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum-=1;
            }else{
                sum+=1;
            }
            if(sum==0){
                maxLen = i+1;
            }
            if(hm.containsKey(sum)){
                int len = i- hm.get(sum);
                maxLen = Math.max(maxLen,len);
            }else{
                hm.put(sum,i);
            }
        }
        return maxLen;
    }
}