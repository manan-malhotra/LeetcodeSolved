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
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<Integer>();
        if(root==null) return arr;
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                if(i==queueSize-1) arr.add(queue.peek().val);
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                queue.poll();
            }
        }
        return arr;
    }
}