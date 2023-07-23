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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int size = findSize(head);

        int totalRotations = size/k;
        int left = 1;
        int right = k;
        while(totalRotations!=0){
            totalRotations--;
            head = reverseBetween(head,left,right);
            left=right+1;
            right+=k;
        }
        return head;
    }
    public int findSize(ListNode head){
        ListNode temp = head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode current = head;
        ListNode prev = null;
        for(int i=0;current!=null && i<left-1;i++){
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;
        ListNode next = current.next;
        for(int i=0; current!=null && i< right-left+1;i++){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null) next=next.next;
        }
        if(last!=null){
            last.next=prev;
        }else{
            head = prev;
        }
        newEnd.next=current;
        return head;
    }
}