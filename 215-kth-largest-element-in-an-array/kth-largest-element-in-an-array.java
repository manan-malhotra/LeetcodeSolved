class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n-k;
        // k:2 n:6 6-2=4 4th elem after sort is 5
         quickSort(nums, 0, n - 1,k);
        return nums[k];
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void quickSort(int[] arr, int low, int high,int k)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            if(pi==k) return;
            if(pi>k) quickSort(arr, low, pi - 1,k);
            else quickSort(arr, pi + 1, high,k);
        }
    }
     static int partition(int[] arr, int low, int high)
    {
        int pivot = findGoodPivot(arr,low,high);
        int i = (low - 1);
        for (int j = low; j <= high ; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static int findGoodPivot(int[] arr,int low, int high){
        // swap(arr,low+1,high);
        return arr[high];
        // if( high-low+1 <=9){
        //     Arrays.sort(arr);
        //     return arr[(arr.length/2)];
        // }
        // int[] temp = null;
        // int len = (int)Math.ceil((double)(high-low+1)/5);
        // int[] medians = new int[len];
        // int mIndex = 0;
        // while(high>=low){
        //     temp = new int[Math.min(5,high-low+1)];
        //     for(int i=0;i<temp.length;i++){
        //         temp[i]=arr[low++];
        //     }
        //     Arrays.sort(temp);
        //     medians[mIndex] = temp[(temp.length/2)-1];
        //     mIndex++;
        // }
        // return findGoodPivot(medians,0,len-1);
        // Arrays.sort(medians);

        // return medians[medians.length/2];
    }
}