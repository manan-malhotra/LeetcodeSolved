class Solution {
    int i=0;
    int p=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return bdt(preorder,inorder,Integer.MIN_VALUE);
    }

    public TreeNode bdt(int[] preorder, int[] inorder, int stop){
        if(p>=preorder.length) return null;

        if(inorder[i]==stop){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p]);
        node.left = bdt(preorder,inorder,preorder[p++]);
        node.right = bdt(preorder,inorder,stop);
        return node;
    }

}