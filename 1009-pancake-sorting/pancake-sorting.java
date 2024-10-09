class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int max=arr.length;
        List<Integer> ans=new ArrayList<>();
        while(max>0){
            int x=0;
            for(int i=0;i<max;i++){
                if(arr[i]==max){
                    x=i;
                    break;
                }
            }
            if(x+1>1) ans.add(x+1);
            rev(arr,x);
            if(max>1) ans.add(max);
            rev(arr,max-1);
            max--;
        }
        return ans;
    }
    public void rev(int arr[],int k){
        int i=0;
        while(i<k){
            int t=arr[i];
            arr[i]=arr[k];
            arr[k]=t;
            i++;k--;
        }
    }
}