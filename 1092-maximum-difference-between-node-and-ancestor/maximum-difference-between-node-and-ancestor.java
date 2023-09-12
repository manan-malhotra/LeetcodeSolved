class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff(root,root.val,root.val);
        return ans;
    }
    public void maxDiff(TreeNode root,int min,int max){
        if(root==null) return;
        ans = Math.max(ans,Math.abs(root.val-min));
        ans = Math.max(ans,Math.abs(root.val-max));
        if(max<root.val) max=root.val;
        if(min>root.val) min=root.val;
        maxDiff(root.left,min,max);
        maxDiff(root.right,min,max);
    }
}