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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root,targetSum,result,new ArrayList<>());
        return result;
    }
    public void pathSum(TreeNode root,int targetSum,List<List<Integer>> result,List<Integer> temp){
        if(isLeaf(root) && root.val==targetSum){
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        if(root==null) return;
        temp.add(root.val);
        pathSum(root.left,targetSum-root.val,result,temp);
        pathSum(root.right,targetSum-root.val,result,temp);
        temp.remove(temp.size()-1);
    }
    public boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }
}