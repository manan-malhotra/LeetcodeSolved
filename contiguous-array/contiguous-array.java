class Solution {
    public int findMaxLength(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int add = 1;
            if(arr[i]==0) add = -1;
            sum+=add;
            if(sum==0){
                maxLen= Math.max(maxLen, i+1);
            }
            if(hm.containsKey(sum)){
                int len = i-hm.get(sum);
                if(len>maxLen){
                    maxLen=len;
                }
            }else{
                hm.put(sum, i);
            }
        }
        return maxLen;
    }
}