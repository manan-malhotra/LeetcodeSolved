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