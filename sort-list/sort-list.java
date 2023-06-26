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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode mid = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwo(left,right);
        
    }
    public ListNode mergeTwo(ListNode left, ListNode right){
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while(left!=null && right!=null){
            if(left.val>right.val){
                temp.next = right;
                right=right.next;
                temp=temp.next;
            }else{
                temp.next = left;
                left=left.next;
                temp=temp.next;
            }
        }
        if(left==null) temp.next=right;
        if(right==null) temp.next=left;
        return dummyHead.next;

    }
    public ListNode getMiddle(ListNode head){
        if(head == null && head.next==null) return head;
        ListNode slow = null;
        while(head!=null && head.next!=null){
            if(slow==null){
                slow = head;
            }else{
            slow = slow.next;
            }
            head=head.next.next;
        }
        ListNode mid = slow.next;
        slow.next=null;
        return mid;
    }
}