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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        return createRoot(nums,0,nums.length-1);
    }
    public TreeNode createRoot(int[] nums, int start, int end){
        if(start>end) return null;
        int mid = start + (end-start)/2;
        return new 
        TreeNode(nums[mid], 
        createRoot(nums,start,mid-1),createRoot(nums,mid+1,end));
    }
}