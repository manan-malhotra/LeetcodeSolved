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
        if(head==null || head.next==null) return;
        ListNode hf = head;
        ListNode mid = findMid(head);
        ListNode hs = reverseList(mid);
        while(hf!=null){
            ListNode temp = hf.next;
            hf.next=hs;
            hf=temp;

            temp = hs.next;
            if(hf!=null){
            hs.next=hf;
            hs=temp;
            }
        }

    }
    public ListNode findMid(ListNode head){
        ListNode slow = null;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow==null? head : slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        return mid;
    }
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while(current!=null){
            current.next=prev;
            prev=current;
            current = next;
            if(next!=null) next=next.next;
        }
        return prev;
    }
}