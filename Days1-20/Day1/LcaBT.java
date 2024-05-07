// LC 236. Lowest Common Ancestor of a Binary Tree - medium
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LcaBT{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if(leftLCA==null){
            return rightLCA;
        }
        if(rightLCA==null){
            return leftLCA;
        }
        return root;
    }

    //main not written as i have picked it up from leetcode
}