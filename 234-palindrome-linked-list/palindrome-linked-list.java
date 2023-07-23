class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
       ListNode fast = head;
       ListNode curr = head;
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           curr=curr.next;
       }
       fast = curr;
       ListNode prev = null;
       ListNode next = curr.next;
       while(curr!=null){
           curr.next=prev;
           prev=curr;
           curr=next;
           if(next!=null) next=next.next;
       }
       curr=head;
       while(curr!=fast && prev !=null){
           if(curr.val==prev.val){
               curr=curr.next;
               prev=prev.next;
           }else{
               return false;
           }
       }    
       return true;
    }
}