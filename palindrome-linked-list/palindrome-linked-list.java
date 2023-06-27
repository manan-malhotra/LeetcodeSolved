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
        if(head==null || head.next==null) return true;
        ListNode mid = findMid(head);
        mid = reverseList(mid);
        while(head!=null && mid!=null){
            if(head.val!=mid.val) return false;
            head=head.next;
            mid=mid.next;
        }
        return true;
        
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        while(p1!=null){
            p1 = head.next;
            head.next = p2;
            p2 = head;
            head = p1;
        }
        return p2;
    }
}