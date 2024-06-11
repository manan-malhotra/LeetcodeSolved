
class Tuple {
    public Tuple(TreeNode x, int row, int col) {
        this.x = x;
        this.row = row;
        this.col = col;
    }

    TreeNode x;
    int row;
    int col;
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> t = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        
        while (!q.isEmpty()) {
            Tuple temp = q.poll();
            TreeNode p = temp.x;
            int x_row = temp.row;
            int y_col = temp.col;
            
            t.putIfAbsent(x_row, new TreeMap<>());
            t.get(x_row).putIfAbsent(y_col, new PriorityQueue<>());
            t.get(x_row).get(y_col).offer(p.val);
            
            if (p.left != null) {
                q.add(new Tuple(p.left, x_row - 1, y_col + 1));
            }
            if (p.right != null) {
                q.add(new Tuple(p.right, x_row + 1, y_col + 1));
            }
        }
        
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : t.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            ans.add(column);
        }
        
        return ans;
    }
}