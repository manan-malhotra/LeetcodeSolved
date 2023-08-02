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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode second = null;

        while(curr!=null){
            if(prev.val>curr.val){
                    System.out.println("CHECK"+prev.val+" "+curr.val);
                    
                    if(first==null){
                        first = prev;
                        second = curr;
                    }else{
                        second=curr;
                    }
                }
            if(curr.left==null){
                prev=curr;
                curr=curr.right;
            }else{
                TreeNode temp = curr.left;
                while(temp.right!=null && temp.right!=curr) temp=temp.right;
                if(temp.right==null){
                    // prev=curr;
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    prev=curr;
                    curr=curr.right;
                    temp.right=null;
                }
            }

        }
        if(first!=null && second!=null){
            System.out.println("FIRST"+first.val+" "+second.val);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
        }
        
        
    }
}