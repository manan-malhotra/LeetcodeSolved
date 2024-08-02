class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 0;
        for(int i=0;i<n;i++){
            if(arr[i]>temp.get(len)){
                temp.add(arr[i]);
                len++;
            }else{
                int index = Collections.binarySearch(temp,arr[i]);
                if(index<0) index = -index - 1;
                temp.set(index,arr[i]);
            }
        }
        return len+1;
    }
}