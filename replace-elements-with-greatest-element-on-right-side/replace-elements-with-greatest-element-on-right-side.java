class Solution {
    public int[] replaceElements(int[] arr) {
        
        for(int i = arr.length-1, max = -1; i >= 0; i--){
            int temp = arr[i];//6
            arr[i] = max;//1
            if(temp > max) max = temp;//6
        }
        return arr;
    }
}