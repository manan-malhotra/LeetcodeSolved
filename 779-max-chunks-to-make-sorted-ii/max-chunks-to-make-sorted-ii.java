class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> a= new Stack<Integer>();

        for(int i=0;i<arr.length;i++)
        {
                int mx=arr[i];
            while(!a.isEmpty()&&arr[i]<a.peek())
            {
                mx= Math.max(mx,a.peek());
                a.pop();
            }

            a.push(mx);
        }
        return(a.size());
    }
}