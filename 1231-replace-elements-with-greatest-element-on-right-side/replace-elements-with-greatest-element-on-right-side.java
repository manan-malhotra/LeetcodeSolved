class Solution {
    public int[] replaceElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(-1);
        if(ans.length>1){

        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>0;i--){
            int max = st.peek();
            if(max>arr[i]){
                st.push(max);
            }else{
                st.push(arr[i]);
            }
        }
        }
        System.out.println(st);
        for(int j=0;j<ans.length;j++){
            ans[j]=st.pop();
        }
        return ans;
        
    }
}