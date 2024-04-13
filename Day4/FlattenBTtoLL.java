// LC 114. Flatten Binary Tree to Linked List - medium 
//striver sheet BT
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
class Solution {
    static TreeNode prev = null;
    public void flatten(TreeNode root) {
        TreeNode cur = root;
		while (cur!=null){
			if(cur.left!=null){
				TreeNode pre = cur.left;
				while(pre.right!=null){
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
    }
}