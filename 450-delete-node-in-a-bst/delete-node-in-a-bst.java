class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        else if(root.val>key){
            root.left=deleteNode(root.left,key);
            
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
        //case1 leafnode
            if(root.right==null && root.left==null){
                return null;
            }
            // single sided node
            else if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            //sub complete bst
            }else{
               TreeNode temp=findmin(root.right);//we can also find for max in left sub tree
               root.val=temp.val;
               root.right=deleteNode(root.right,temp.val);
                
                
            }         
            
        }
        return root;
    }
    
    public TreeNode findmin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}