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
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
    }

    public TreeNode build(int[] preorder, int ps, int pe,
    int[] inorder, int is,int ie,HashMap<Integer,Integer> hm){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int index = hm.get(preorder[ps]);
        root.left = build(preorder,ps+1,ps+(index-is),inorder,is,index-1,hm);
        root.right = build(preorder,ps+(index-is)+1,pe,inorder,index+1,ie,hm);
        return root;
    }



}