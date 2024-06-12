class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> hashSet =new HashSet<>();
        return help(root,k,hashSet);
    }
    public boolean help(TreeNode root,int k,Set<Integer> hashSet )
    {
        if(root==null)return false;
        if(hashSet.contains(k-root.val))return true;
        hashSet.add(root.val);
        return help(root.left,k,hashSet)||help(root.right,k,hashSet);
    }
}