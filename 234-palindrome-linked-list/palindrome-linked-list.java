/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // find mid
        ListNode mid = middleNode(head);
        // reverse from mid
        ListNode reversemid = reverseList(mid);

        ListNode left = head;
        ListNode right = reversemid;
        System.out.println(left.val);
        while(left!=mid && right!=null){
            if(left.val!=right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode curr) {
        if(curr==null) return curr;
        ListNode next = curr.next;
        ListNode p = null;
        while(curr!=null){
            curr.next = p;
            p = curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        return p;
    }
}