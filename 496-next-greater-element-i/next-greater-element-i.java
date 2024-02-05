class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] next = new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            System.out.println(st);
            if(st.isEmpty()){
                next[i]=-1;
                st.push(nums2[i]);
            }
            else{
                int num = st.peek();
                if(nums2[i]<num){
                    next[i]=num;
                    st.push(nums2[i]);
                }else{
                    while(true){
                        if(!st.isEmpty() && st.peek()<=nums2[i]){
                            st.pop();
                        }else{
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            hm.put(nums2[i],i);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=next[hm.get(nums1[i])];
        }
    return nums1;
    }

}