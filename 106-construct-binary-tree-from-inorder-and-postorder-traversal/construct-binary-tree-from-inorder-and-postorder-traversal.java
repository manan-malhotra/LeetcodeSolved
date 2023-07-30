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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    Map < Integer, Integer > hm = new HashMap < Integer, Integer > ();

    for (int i = 0; i < inorder.length; i++) {
      hm.put(inorder[i], i);
    }

    return build(postorder, 0, postorder.length - 1, inorder, 0, 
    inorder.length - 1, hm);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map < Integer, Integer > hm){
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = hm.get(postorder[postEnd]);
        root.left=build(postorder,postStart,postStart+inRoot-inStart-1,inorder,inStart,inRoot-1,hm);
        root.right=build(postorder,postStart+inRoot-inStart,postEnd-1,inorder,inRoot+1,inEnd,hm);


// TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps,
//         ps+ri-is-1, hm);
//         TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, 
//         ps+ri-is, pe-1, hm);

        return root;
    }


}