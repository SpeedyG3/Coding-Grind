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
//striver a2z
// LC 450. Delete Node in a BST - medium 
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            return delete(root);
        }
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val>key){
                if(temp.left!=null && temp.left.val==key){
                    temp.left = delete(temp.left);
                    break;
                }else{
                    temp = temp.left;
                }
            }else{
                if(temp.right!=null && temp.right.val==key){
                    temp.right = delete(temp.right);
                    break;
                }else{
                    temp = temp.right;
                }
            }
        }
        return root;
    }

    public static TreeNode delete(TreeNode node){
        if(node.left==null){
            return node.right;
        }
        else if(node.right==null){
            return node.left;
        }else{ //case where both left and right subtrees are not null
            TreeNode rightChild = node.right;
            TreeNode last = findLast(node.left);
            last.right = rightChild;
            return node.left;
        }
    }

    public static TreeNode findLast(TreeNode node){
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}