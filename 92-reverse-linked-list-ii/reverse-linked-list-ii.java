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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode temp = head;
        ListNode orignalPrev = null;
        ListNode lNode = null;
        ListNode rNode = null;
        for(int i=1;i<=right;i++){
            if((i+1) == left) orignalPrev = temp;
            if(i==left) lNode = temp;
            if(i==right) rNode = temp;
            temp=temp.next;
        }
        ListNode prev = orignalPrev;
        ListNode curr = lNode;
        ListNode next = lNode.next;
        while(prev!=rNode){
            curr.next = prev;
            prev=curr;
            curr=next;
            if(next!=null) next=next.next;
        }
        if(orignalPrev == null) head = prev;
        else orignalPrev.next = prev;
        lNode.next = curr;
        return head;
    }
}