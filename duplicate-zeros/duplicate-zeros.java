class Solution {
    public void duplicateZeros(int[] arr) 
    {
        int noOfZeros = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i] == 0) noOfZeros++;
        }
        for(int i=n-1;i>=0;i--)
        {
            int curIndex = i+noOfZeros;
            if(curIndex<n)
            {
                arr[curIndex] = arr[i];
            }
            if(arr[i] == 0)
            {
                if(curIndex-1 < n)
                {
                    arr[curIndex-1] = arr[i];
                }
                noOfZeros--;
            }
        } 
    }
}