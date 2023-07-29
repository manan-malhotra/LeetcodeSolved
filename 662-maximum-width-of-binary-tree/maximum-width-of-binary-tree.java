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
class Pair{
    TreeNode node;
    int value;

    public Pair(TreeNode node,int value){
        this.node=node;
        this.value=value;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root==null) return maxWidth;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int mini = q.peek().value;
            int size = q.size();
            int first = 0,last = 0;
            for(int i=0;i<size;i++){
                int cur_id = q.peek().value-mini;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left!=null) q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right!=null) q.offer(new Pair(node.right, cur_id*2+2));
                maxWidth = Math.max(maxWidth,last-first+1);
            }
        }
        return maxWidth;
    }

}