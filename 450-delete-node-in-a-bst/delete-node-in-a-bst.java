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
                root=null;
                return root;
            }
            // single sided node
            else if(root.right==null){
                TreeNode temp=root.left;
                root=null;
                return temp ;
            }else if(root.left==null){
                TreeNode temp=root.right;
                root=null;
                return temp;
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