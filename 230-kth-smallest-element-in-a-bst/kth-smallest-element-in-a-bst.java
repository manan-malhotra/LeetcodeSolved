class Solution {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;        
        helper(root);
        int count=1;
        while(count<k){
            pq.poll();
            count++;
        }   
        return pq.poll(); 
    }
    public void helper(TreeNode root){
        if(root==null) return;      
        pq.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}