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
        ListNode current= head;
        ListNode previous=null;
        while(current!=null){
            ListNode temp=current.next;
            current.next=previous;
            previous=current;
            current=temp;
        }

       return previous; 
    }
    public int pairSum(ListNode head) {
        if(head==null||head.next==null)return 0;
        ListNode slow =head;
        ListNode fast =head.next;
        if(fast.next==null)return slow.val+fast.val;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow.next!=null){
           fast= reverseList(slow.next);
        }
        int max=0;
        while(head!=slow.next&&fast!=null){
             max=Math.max(max,head.val+fast.val);
             head=head.next;
             fast=fast.next;
        }
       return max; 
    }
}