/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next=node;
            temp=node.next;
        }
        temp = head;
        while(temp!=null){

            temp.next.random = temp.random==null?null:temp.random.next;
            temp=temp.next.next;
        }
        Node newHead = head.next;
        Node newTemp = newHead;
        temp = head;
        while(newTemp!=null && newTemp.next!=null){
            temp.next=temp.next.next;
            newTemp.next=newTemp.next.next;
            temp=temp.next;
            newTemp=newTemp.next;
        }
        if(temp!=null) temp.next=null;
        return newHead;

    }
   
}