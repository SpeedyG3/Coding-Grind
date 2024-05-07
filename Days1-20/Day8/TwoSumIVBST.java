/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// LC 653. Two Sum IV - Input is a BST - easy
//brute force is to get inorder traversal and then do using 2 pts to get answer
// optimal way - striver 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i=l.next(); //initially i gives smallest element
        int j=r.next(); //initially j gives largest element
        while(i<j){
            int sum = i+j;
            if(sum==k){
                return true;
            }else if(sum<k){
                i = l.next();
            }else{
                j = r.next();
            }
        }
        return false;
    }
}

public class BSTIterator{
    Stack<TreeNode> st=new Stack<>();
    boolean reverse;
    public  BSTIterator(TreeNode root,boolean isreverse){
        reverse=isreverse;
        addelements(root);
    }

    public void addelements(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
    }

    public int next(){
        TreeNode node=st.pop();
        if(reverse){
            addelements(node.left);
        }
        else addelements(node.right);
        return node.val; 
    }

    public boolean hasnext(){
        return !st.isEmpty();
    }
}