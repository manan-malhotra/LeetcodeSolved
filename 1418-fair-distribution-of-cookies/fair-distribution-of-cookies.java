class Solution {
    public int distributeCookies(int[] nums, int k) {
        
          int set[] = new int[k];
       
           helper(set,nums,nums.length-1);
         return ans;
    }
   
   int ans=Integer.MAX_VALUE; 
    public void helper(int[] set, int[] nums, int idx) {

            
        if (idx == -1) {
            int mx=0;
            for (int ss : set) {
                
                mx=Math.max(mx,ss);
            }

            ans=Math.min(ans,mx);
            return;
        }
              
        for (int j = 0; j < set.length; j++) {

            
                set[j] += nums[idx];

                helper(set, nums, idx -1); 
                 

                set[j] -= nums[idx];
            

            if (set[j] == 0)
                break;

        }

        return ;

    }
}