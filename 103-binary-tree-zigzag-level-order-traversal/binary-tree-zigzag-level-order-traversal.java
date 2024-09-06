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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,ans,0,false);
        return ans;
    }
    public void helper(TreeNode root, List<List<Integer>> ans, int level, boolean isReverse){
        if(root==null) return;
        if(ans.size()<=level) ans.add(new ArrayList<>());
        if(isReverse) ans.get(level).add(0,root.val);
        else ans.get(level).add(root.val);
        helper(root.left, ans, level+1, !isReverse);
        helper(root.right, ans, level+1, !isReverse);
    }
}