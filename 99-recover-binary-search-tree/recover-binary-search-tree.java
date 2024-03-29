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
   TreeNode prev;
   TreeNode f;
   TreeNode s;
    public void recoverTree(TreeNode root) {
      prev = new TreeNode(Integer.MIN_VALUE);
      inorder(root);
      //System.out.println(f.val+" "+s.val);
      int temp = f.val;
      f.val = s.val;
      s.val = temp;
    }
    public void inorder(TreeNode root){
      if(root==null) return;
      inorder(root.left);
      if(prev.val>root.val){
        //System.out.println(prev.val+" "+root.val);
        if(f==null){
          f=prev;
          s=root;
        }else if(f!=null){
          //System.out.println(f.val);
          s=root;
        }
      }
      prev=root;
      inorder(root.right);
    }
}