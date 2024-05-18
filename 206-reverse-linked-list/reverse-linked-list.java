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