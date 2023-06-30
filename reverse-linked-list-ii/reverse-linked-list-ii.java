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
        if(head==null || head.next==null || left==right) return head;
        ListNode curr = head;
        ListNode last = null;
        for(int i=1;curr!=null && i<left;i++){
            curr=curr.next;
            last=last==null?head:last.next;
        }
        ListNode prev = last;
        ListNode newEnd = curr;
        ListNode next = curr.next;
        for(int i=0;i<right-left+1;i++){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next==null?null:next.next;
        }
        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=curr;
        return head;
    }
}