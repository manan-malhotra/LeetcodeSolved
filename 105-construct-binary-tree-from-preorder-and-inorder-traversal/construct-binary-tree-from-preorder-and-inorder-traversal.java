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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        if(preorder.length==0) return null;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }    
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,HashMap<Integer,Integer> hm){
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hm.get(preorder[preStart]);
        int numsLeft = inRoot-inStart;

        root.left = buildTree(preorder,preStart+1,preStart + numsLeft,inorder,inStart,inRoot-1,hm);
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,hm);

        return root;


    }
    
}