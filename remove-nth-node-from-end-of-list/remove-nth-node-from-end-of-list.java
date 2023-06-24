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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = length(head) - n;
        if(index==0) {
            return head.next;
        }
        ListNode temp = head;
        for(int i = 1; i < index; i ++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        
        return head;
    }
    public int length(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}