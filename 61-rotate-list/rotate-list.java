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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        if(temp==null) return head;
        int length = 1;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        k = k%length;
        if(k==0) return head;
        k=length-k;
        temp.next=head;
        temp = head;
        while(k!=1){
            k--;
            temp = temp.next;
        }
        head = temp.next;
        temp.next=null;
        return head;
    }
}