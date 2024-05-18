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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode head = h1.val>=h2.val?h2:h1;
        ListNode temp = null;
        while(h2!=null){
            if(h1.next==null && h1.val<h2.val){
                h1.next=h2;
                break;
            }
            else if(h1.val<h2.val){
                temp = h1;
                h1=h1.next;
            }else{
                if(temp!=null) temp.next=h2;
                temp = h2;
                h2=h2.next;
                temp.next=h1;
            }
            
        }

        return head;
        
    }
}