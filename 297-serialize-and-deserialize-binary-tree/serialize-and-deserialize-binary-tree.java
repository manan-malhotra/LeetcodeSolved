/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                str.append("n,");
            } else {
                str.append(node.val);
                str.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size!=0){
                size--;
                String leftVal = (dataArr[i++]);
                String rightVal = (dataArr[i++]);
                TreeNode node = queue.poll();
                if(!leftVal.equals("n")){
                    node.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.offer(node.left);
                }
                if(!rightVal.equals("n")){
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));