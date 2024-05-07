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
//Striver BST 
// LC 98. Validate Binary Search Tree
class Solution {
    public static boolean isValidBST_Helper(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }

        if(root.val<=min || root.val>=max){
            return false;
        }

        return isValidBST_Helper(root.left, min, root.val) && 
        isValidBST_Helper(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST_Helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}