class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //since we have to find the missing numbers from
        //store the  valuses of all array elments in map
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],1);
        }
        List<Integer> ans=new ArrayList<>();
        //now check the given array 
        //nums from 1 to nums.length(incusive) if
        //it the i is not in map means it is missing
        //add to ans list
        for(int i=1;i<=nums.length;i++)
        {
            if(map.containsKey(i)==false)
            {
                ans.add(i);
            }
        }
        return ans;
		//please upvote if you found helpful it will give some motivation
        
    }
}