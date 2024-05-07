/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//striver BST
// LC 235. Lowest Common Ancestor of a Binary Search Tree - medium 
//recursive 
// tc -> O(H) sc->O(n) stack space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        int curr = root.val;
        if(curr<p.val && curr<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else if(curr>p.val && curr>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            //means that we either have on node on left and other on right 
            //or another case where one of the 2 nodes from the lca we are to find has been
            //encounter by us
            //so -
            return root;
        }
        //so this soln is similar to the one i submitted previously on lc
    }
}

//iterative 
// tc -> O(H) sc->O(1) 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //iterative solution similar to the one i submitted before this
        TreeNode node = root;
        while(node!=null){
            if(node.val>p.val && node.val>q.val){
                node = node.left;
            }else if(node.val<p.val && node.val<q.val){
                node = node.right;
            }else{
                //case where we split the path or one of the 2 nodes we are to find lca of 
                //has been encountered by us 
                return node;
            }
        }
        return null;
    }
}