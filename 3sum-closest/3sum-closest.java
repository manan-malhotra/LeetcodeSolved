class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        int closestSum=0;
        int n = arr.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    sum=arr[i]+arr[j]+arr[k];
                    int diff = Math.abs(target-sum);
                   
                    if(closest>diff){
                        closest=diff;
                        closestSum=sum;
                    }
                }
            }
        }
        return closestSum;
    }
}