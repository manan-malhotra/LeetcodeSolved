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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode left=null;
        ListNode right=null;
        ListNode temp=head;
        ListNode lhead=null; ListNode rhead=null;
        while(temp!=null){
            if(temp.val>=x){
                if(right==null){
                    right=temp;
                    rhead=right;
                }else{
                    right.next=temp;
                    right=right.next;
                }
            }else{
                if(left==null){
                    left=temp;
                    lhead=left;
                }else{
                    left.next=temp;
                    left=left.next;
                }
            }
            temp=temp.next;
        }
        if(right!=null){
            right.next=null;
        }
        if(left!=null){
            left.next=rhead;
        }
        return lhead!=null? lhead:rhead;
    }
}