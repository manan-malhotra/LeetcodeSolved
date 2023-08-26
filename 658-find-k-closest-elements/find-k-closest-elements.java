class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int c) {
            int n = arr.length;
            if(c>=arr[n-1]){
                return adde(arr,n-k,n);
            }
            else if(c<=arr[0]){
                return adde(arr,0,k);
            }else{
            int l = 0;
            int r = n-1;
            while(r-l!=k-1){
                int leftVal = Math.abs(arr[l]-c);
                int rightVal = Math.abs(arr[r]-c);
                if(leftVal>rightVal){
                    l++;
                }else{
                    r--;
                }
            }
            return adde(arr,l,r+1);
        }
        }
        public List<Integer> adde(int[] arr, int l, int r){
            List<Integer> a = new ArrayList<Integer>();
            for(int i=l;i<r;i++) a.add(arr[i]);
            return a;
        }
}