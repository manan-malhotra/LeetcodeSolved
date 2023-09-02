/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        return kthSmallest(root,arr,k);
        
    }
    int count = 0;
    public int kthSmallest(TreeNode root, List<Integer> arr,int k){
        if(root==null) return -1;
        int left = kthSmallest(root.left,arr,k);
        if(left!=-1) return left;
        count++;
        if(count==k) return root.val;
        return kthSmallest(root.right,arr,k);
        
    }
}