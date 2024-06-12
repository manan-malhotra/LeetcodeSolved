class Solution {
    int ans=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        kthSmallestHelper(root,k);
        return ans;
    }
    public void kthSmallestHelper(TreeNode root, int k) {
        if(root==null)  return;
        kthSmallestHelper(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }
}