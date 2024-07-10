class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        int n = arr.length;
        int res = diffUptoK(arr,n,k) - diffUptoK(arr,n,k-1);
        return res;
    }
    public static int diffUptoK(int[] arr, int n, int k){
      if(k<=0) return 0;
      int count = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      int i=0, j=0;
      while(j!=n){
        map.put(arr[j],map.getOrDefault(arr[j], 0)+1);
        while(map.size()>k){
          map.put(arr[i],map.get(arr[i])-1);
          if(map.get(arr[i])==0){
            map.remove(arr[i]);
          }
          i++;
        }
        count+=(j-i+1);
        j++;
      }
      return count;
    }
}