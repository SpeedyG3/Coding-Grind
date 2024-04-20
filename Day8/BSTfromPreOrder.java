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
//striver - optimised
// LC 1008. Construct Binary Search Tree from Preorder Traversal - medium
class Solution {
    public static TreeNode buildTree(int ub, int preorder[], int i[]){
        if(i[0]==preorder.length || preorder[i[0]]>ub){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = buildTree(root.val, preorder, i);
        root.right = buildTree(ub, preorder, i);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(Integer.MAX_VALUE, preorder, new int[]{0});
    }
}