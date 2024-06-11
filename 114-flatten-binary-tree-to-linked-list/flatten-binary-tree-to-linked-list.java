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
    public void flatten(TreeNode root) {
        List<TreeNode> pre = new ArrayList<>();
        preOrder(root,pre);
        
        for(int i=0;i<pre.size();i++){
            TreeNode curr = pre.get(i);
            curr.left=null;
            if(i!=pre.size()-1) curr.right=pre.get(i+1);
        }
    }
    public void preOrder(TreeNode root, List<TreeNode> pre){
        if(root==null) return;
        pre.add(root);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }
}