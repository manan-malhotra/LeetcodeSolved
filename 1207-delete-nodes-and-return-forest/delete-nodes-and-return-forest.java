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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int node : to_delete) set.add(node);
        List<TreeNode> ans = new ArrayList<>();
        delete(root,set,ans);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode delete(TreeNode root, HashSet<Integer> set, List<TreeNode> ans){
        if(root==null) return null;
        root.left = delete(root.left,set,ans);
        root.right = delete(root.right,set,ans);
        if(set.contains(root.val)){
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            return null;
        }
        return root;
    }
}