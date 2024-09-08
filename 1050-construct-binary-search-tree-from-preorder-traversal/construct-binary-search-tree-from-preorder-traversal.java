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
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);
            for(int i=1;i<preorder.length;i++){
                buildTree(root,preorder[i]);
            }
            return root;
        }

        public void buildTree(TreeNode root,int newVal){
            if(root.val>newVal){
                if(root.left!=null){
                    buildTree(root.left,newVal);
                }else{
                    root.left = new TreeNode(newVal);
                    return;
                }
            }else{
                if(root.right!=null){
                    buildTree(root.right,newVal);
                }else{
                    root.right = new TreeNode(newVal);
                    return;
                }
            }
        }
    }