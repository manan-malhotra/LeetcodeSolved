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
class Info{
    int sum;
    int n;
    Info(int sum,int n){
        this.sum=sum;
        this.n=n;
    }
}
class Solution {
    private Info solve(TreeNode root){
        if(root==null) return new Info(0,0);
        Info l=solve(root.left);
        Info r=solve(root.right);
        int sum=l.sum+r.sum+root.val;
        int n=l.n+r.n+1;
        if(root.val==sum/n) ans++;
        return new Info(sum,n);
    }
    private int ans;
    public int averageOfSubtree(TreeNode root) {
        ans=0;
        solve(root);
        return ans;
    }
}