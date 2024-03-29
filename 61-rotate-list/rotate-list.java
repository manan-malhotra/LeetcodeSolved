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
        if(k==0 || head==null || head.next==null) return head;
        int size = 1;
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            temp = temp.next;
            size++;
        }
        temp.next = head;
        int rotations = k%size;
        rotations = size - rotations;
        temp=head;
        for(int i=1;i<rotations;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}