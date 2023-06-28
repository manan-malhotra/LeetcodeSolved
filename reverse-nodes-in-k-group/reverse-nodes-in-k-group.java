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
        int size = findSize(head);
        int totalDiv = size/k;
        int startIndex = 1;
        int endIndex = k;
        while(totalDiv!=0){
            head = reverseBetween(head,startIndex,endIndex);
            startIndex=endIndex+1;
            endIndex += k; 
            totalDiv--;
        }
        return head;
    }
    public int findSize(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    public ListNode reverseBetween(ListNode head, int left, int right){
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