class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return help(root, k, root);
    }
    private boolean help(TreeNode root, int k, TreeNode root2) {
        if(root == null) return false;
        if(find(root2, k - root.val, root))    return true;
        return help(root.left, k, root2) || help(root.right, k, root2); 
    }
    private boolean find(TreeNode root, int target, TreeNode org) {
        if(root == null) return false;
        if(root.val == target && root != org) return true;
        if(root.val < target)    return find(root.right, target, org);
        return find(root.left, target, org);
    }
}