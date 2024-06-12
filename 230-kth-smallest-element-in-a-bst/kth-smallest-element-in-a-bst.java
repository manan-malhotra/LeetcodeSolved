class Solution {
    PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->y-x);
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;        
        helper(root,k);
        return pq.poll(); 
    }
    public void helper(TreeNode root,int k){
        if(root==null) return;      
        helper(root.left,k);
        pq.add(root.val);
        if(pq.size()>k) pq.poll();
        helper(root.right,k);
    }
}