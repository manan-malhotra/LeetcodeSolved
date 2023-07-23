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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p1 = head.next;
        ListNode p2 = null;
        while(head!=null){
            head.next = p2;
            p2 = head;
            head = p1;
            if(p1!=null) p1=p1.next;
        }
        return p2;
    }
}