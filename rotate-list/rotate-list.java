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
        if(head==null || head.next==null) return head;
        if(k==0) return head;
        ListNode temp = head;
        int size = 1;
        while(temp!=null && temp.next!=null){
            size++;
            temp=temp.next;
        }
        int rotations = k%size;
        if(rotations==0) return head;
        else{
            temp.next=head;
        }
        int newHead = size-rotations;
        temp = head;
        while(newHead!=1){
            temp=temp.next;
            newHead--;
        }
        head=temp.next;
        temp.next=null;
        return head;

    }
}