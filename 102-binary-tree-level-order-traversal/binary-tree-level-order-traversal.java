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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int height = height(root);
        for(int i=0;i<height;i++){
            ans.add(new ArrayList<>());
        }
        levelOrder(root,0,ans);
        return ans;
    }
    public int height(TreeNode root) {
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public void levelOrder(TreeNode root, int level,List<List<Integer>> ans){
        if(root == null) return;
        ans.get(level).add(root.val);
        levelOrder(root.left,level+1,ans);
        levelOrder(root.right,level+1,ans);

    }
}