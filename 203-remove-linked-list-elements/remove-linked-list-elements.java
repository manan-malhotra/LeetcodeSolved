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
    public ListNode removeElements(ListNode head, int target) {
        ListNode temp = head;
        while(temp!=null && temp.val==target){
            head=temp.next;
            temp=head;
        }
        while(temp!=null && temp.next!=null){
            if(temp.next.val==target){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;

    }
}