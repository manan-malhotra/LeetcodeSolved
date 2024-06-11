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
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        // contains <Node,ParentOfNode> in map
        createParentMap(root,parentMap);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        visited.add(target);
        q.offer(target);
        int distance = 0;
        while(!q.isEmpty() ){
            if(distance==k){
                break;
            }
            int size = q.size();
            distance++;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                TreeNode parent = parentMap.getOrDefault(node,null);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);
                }
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!=null && !visited.contains(left)){
                    visited.add(left);
                    q.offer(left);
                }
                if(right!=null && !visited.contains(right)){
                    visited.add(right);
                    q.offer(right);
                }
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
    public void createParentMap(TreeNode root,HashMap<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if(parent.left!=null){
                parentMap.put(parent.left,parent);
                q.offer(parent.left);
            }
            if(parent.right!=null){
                parentMap.put(parent.right,parent);
                q.offer(parent.right);
            }
        }
    }
}