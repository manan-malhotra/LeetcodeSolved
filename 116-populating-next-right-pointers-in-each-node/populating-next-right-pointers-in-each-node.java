/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root==null) return root;
        Node curr = root;
        Node nextLevel = null;
        boolean first = true;
        curr.next=null;
        while(curr!=null){
            if(first){
                nextLevel = curr.left;
                first=false;
            }
            if(curr.left==null) break;
            curr.left.next=curr.right;
            if(curr.next==null){
                curr.right.next=null;
                curr=nextLevel;
                first=true;
            }else{
                curr.right.next=curr.next.left;
                curr=curr.next;
            }

        }
        return root;
    }
}