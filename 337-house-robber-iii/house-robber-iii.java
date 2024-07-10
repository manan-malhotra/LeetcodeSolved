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
  
    public int rob(TreeNode root) {
        return rob(root, 0, 0, new HashMap<>());
    }
    public int rob(TreeNode node, int left, int right, HashMap<TreeNode, Integer> map){
        if(node == null)return 0;
        if(node.right == null && node.left == null) return node.val;

        if(map.containsKey(node))return map.get(node);

        if(node.left!=null)
            left = rob(node.left.left, 0, 0, map) + rob(node.left.right, 0, 0, map);
        if(node.right!=null)
            right = rob(node.right.right, 0, 0, map)+ rob(node.right.left, 0 ,0, map);

        int sum  = left + right + node.val;

        int result  = Math.max(sum, rob(node.left,0, 0, map) + rob(node.right,0, 0, map));
        map.put(node, result);
        return result;
    }
}