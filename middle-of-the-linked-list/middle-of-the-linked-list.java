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
    public ListNode middleNode(ListNode head) {
        int half = length(head)/2;
        for(int i=0;i<half;i++){
            head=head.next;
        }
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