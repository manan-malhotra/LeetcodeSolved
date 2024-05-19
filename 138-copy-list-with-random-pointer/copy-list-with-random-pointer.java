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
        Node t = head;
        if(t==null) return null;
        while(t!=null){
            Node node = new Node(t.val);
            node.next = t.next;
            t.next=node;
            t=node.next;
        }

        t=head;
        while(t!=null){
            t.next.random = t.random==null?null:t.random.next;
            t=t.next.next;
        }
        Node newHead = head.next;
        t=head;
        Node temp=newHead;
        while(t!=null){
            t.next = temp.next;
            if(temp.next!=null) temp.next=temp.next.next;
            t=t.next;
            temp=temp.next;
        }
        return newHead;
    }
}