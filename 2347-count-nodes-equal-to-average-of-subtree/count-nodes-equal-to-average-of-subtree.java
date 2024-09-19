public class Solution {
    int count;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    Pair<Integer, Integer> dfs(TreeNode node) {
        if (node == null)
            return new Pair<>(0, 0);

        Pair<Integer, Integer> left = dfs(node.left);
        Pair<Integer, Integer> right = dfs(node.right);

        int nodeSum = node.val + left.getKey() + right.getKey();
        int nodeCount = 1 + left.getValue() + right.getValue();

        if (node.val == nodeSum / nodeCount) {
            count++;
        }

        return new Pair<>(nodeSum, nodeCount);
    }
}