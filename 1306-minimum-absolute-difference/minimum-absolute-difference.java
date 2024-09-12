class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list =  new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length-1;i++){
            min = Math.min(min,Math.abs(arr[i]-arr[i+1]));
        }
        for(int i = 0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1])==min){
                list.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
     
        return list;
        
    }
}