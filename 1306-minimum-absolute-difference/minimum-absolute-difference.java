class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length; 
        List<List<Integer>> result = new ArrayList<>();

        int min = 0; 

        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++){
            int diff = arr[i + 1] - arr[i];

            if(i == 0){
                min = diff; 
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else{
                if(min >= diff){
                    if(diff < min){
                        result = new ArrayList<>();
                    }
                    min = diff;
                    result.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
        }
        return result;
    }
}