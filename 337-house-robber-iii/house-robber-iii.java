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
        int rob[] = {0} ,notRob[] = {0};
        return getMax(root,rob,notRob);
    }
    public int getMax(TreeNode root ,int rob[] ,int notRob[]){
        if(root == null) return 0;
        int leftRob[] = {0} ,leftNotRob[] = {0} ,rightRob[] = {0} , rightNotRob[] = {0};
        int left = getMax(root.left,leftRob,leftNotRob);
        int right = getMax(root.right,rightRob,rightNotRob);
        rob[0] = root.val + leftNotRob[0] + rightNotRob[0];
        notRob[0] = left + right;
        return Math.max(rob[0],notRob[0]);
    }
}