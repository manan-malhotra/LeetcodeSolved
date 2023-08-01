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
    public int kthSmallest(TreeNode root, int k) {
        int ans = -1;
        int count = 0;
        if(root!=null){
            TreeNode curr = root;
            while(curr!=null){
                
                if(curr.left==null){
                    count++;
                    if(count==k) return curr.val;
                    curr=curr.right;
                }else{
                    TreeNode temp = curr.left;
                    while(temp.right!=null && temp.right!=curr){
                        temp=temp.right;
                    }
                    if(temp.right==null){
                        temp.right=curr;
                        curr=curr.left;
                    }else{
                        temp.right=null;
                        count++;
                        if(count==k) return curr.val;
                        curr=curr.right;
                    }
                }
            }
        }


        return ans;
    }
}