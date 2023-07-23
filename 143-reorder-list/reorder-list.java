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
        ListNode slow = head;
        ListNode fast = head;
        ListNode end = null;
        while(fast!=null && fast.next!=null){
            if(end==null) end=head;
            else end=end.next;
            slow=slow.next;
            fast=fast.next.next;
        }
        end.next=null;
        end = null;
        fast=slow.next;
        while(slow!=null){
            slow.next=end;
            end=slow;
            slow=fast;
            if(fast!=null) fast=fast.next;
        }
        slow = end;
        fast = head;
        while(fast!=null){
            end = fast.next;
            fast.next = slow;
            fast = end;
            end=slow.next;
            if(fast!=null) slow.next=fast;
            
            slow=end;
        }
        if(fast!=null) System.out.println(fast.val);
        
    }
}