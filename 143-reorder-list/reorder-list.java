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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return ;
        ListNode slow = null;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            if(slow==null){
                slow=head;
            }else{
                slow = slow.next;
            }
            fast = fast.next.next;
        }
        ListNode midHead = slow.next;
        slow.next = null; // removing connection from mid;
        midHead = reverseList(midHead);

        ListNode a = head;
        ListNode b = midHead;
        while(a!=null){
            ListNode X = a.next;
            ListNode Y = b.next;
            a.next = b;
            if(X!=null) b.next = X;
            a=X;
            b=Y;
        }
        return ;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
}