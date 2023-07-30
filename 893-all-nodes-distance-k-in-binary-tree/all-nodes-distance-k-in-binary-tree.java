/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                    parent.put(node.left,node);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    parent.put(node.right,node);
                }
            }
        }
        int distance = 0;
        q.offer(target);
        visited.put(target,true);
        while(!q.isEmpty()){
            if(distance==k) break;
            distance++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(parent.containsKey(node)){
                    TreeNode par = parent.get(node);
                    if(!visited.containsKey(par)){
                    q.offer(par);
                    visited.put(par,true);
                    }
                }
                if(node.left!=null){
                    if(!visited.containsKey(node.left)){
                        q.offer(node.left);
                        visited.put(node.left,true);
                    }
                }
                if(node.right!=null){
                    if(!visited.containsKey(node.right)){
                        q.offer(node.right);
                        visited.put(node.right,true);
                    }
                }

            }
            
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}