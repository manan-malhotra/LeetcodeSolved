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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;
        while(i!=left){
            if(prev==null) prev=head;
            else prev=prev.next;
            curr=curr.next;
            i++;
        }
        ListNode last = prev;
        ListNode startFrom = curr;
        ListNode next = curr.next;
        int reverse = right - left + 1;
        while(reverse!=0){
            reverse--;
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        startFrom.next=curr;
        if(last!=null) last.next=prev;
        else head=prev;
        return head;
    }
}