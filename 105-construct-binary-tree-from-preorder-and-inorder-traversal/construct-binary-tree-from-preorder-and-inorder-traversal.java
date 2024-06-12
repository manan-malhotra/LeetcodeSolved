class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            hm.put(inorder[i],i);
        }
        int[] index = {0};
        int l = 0;
        int r = inorder.length-1;
        return helper(preorder,inorder,l,r,hm,index);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int l, int r, HashMap<Integer,Integer> hm,int[] index){
        if(l>r) return null;
        int current = preorder[index[0]];
        index[0]++;
        TreeNode node = new TreeNode(current);
        if(l==r) return node;
        int inOrderIndex = hm.get(current);
        node.left=helper(preorder,inorder,l,inOrderIndex-1,hm,index);
        node.right=helper(preorder,inorder,inOrderIndex+1,r,hm,index);
        return node;
    }
}