class Solution {
    public void duplicateZeros(int[] arr) 
    {
        int zero = 0;
        int n = arr.length;
        for(int i:arr){
            if(i==0) zero++;
        }
        for(int i=n-1;i>=0;i--)
        {
            int actualPos = i+zero;
            if(actualPos<n)
            {
                arr[actualPos] = arr[i];
            }
            if(arr[i] == 0)
            {
                if(actualPos-1 < n)
                {
                    arr[actualPos-1] = arr[i];
                }
                zero--;
            }
        } 
    }
}