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
        if(head.next==null) return ;
        ListNode mid = findMid(head);
        ListNode secondHead = mid.next;
        mid.next = null;
        secondHead = reverse(secondHead);
        combine(head,secondHead);
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)next = next.next;
        }
        return prev;
    }

    public void combine(ListNode first, ListNode second){
        ListNode temp1 = first;
        ListNode temp2 = second;
        while(second!=null){
            temp1 = first.next;
            temp2 = second.next;
            first.next = second;
            first = temp1;
            second.next = first;
            second = temp2;
        }
    }

    
}