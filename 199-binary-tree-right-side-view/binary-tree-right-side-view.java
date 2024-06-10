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
    public List<Integer> rightSideView(TreeNode root) {
       List<List<Integer>> ans = levelOrder(root);
       List<Integer> result = new ArrayList<>();
        for(List<Integer> list:ans){
            result.add(list.get(list.size()-1));
       }
       return result;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    private void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (ans.size() <= level)
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
    }
}