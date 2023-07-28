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
        if(root==null) return ans;
        boolean isReverse = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<TreeNode> stack = new Stack<>();
        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                if(isReverse){
                    if(queue.peek().left!=null){
                        stack.push(queue.peek().left);
                    }
                    if(queue.peek().right!=null){
                        stack.push(queue.peek().right);
                    }
                    arr.add(queue.poll().val);
                }else{
                    
                    if(queue.peek().right!=null){
                        stack.push(queue.peek().right);
                    }
                    if(queue.peek().left!=null){
                        stack.push(queue.peek().left);
                    }
                    arr.add(queue.poll().val);
                }
            }
            if(isReverse){
                isReverse=false;
            }else{
                isReverse=true;
            }
            while(!stack.isEmpty()){
                queue.offer(stack.pop());
            }
            ans.add(arr);
        }
        return ans;
    }
}