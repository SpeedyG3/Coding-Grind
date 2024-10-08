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
//write main
// 144. Binary Tree Preorder Traversal - easy
// striver morris triversal tc->o(n) and sc->o(1)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){ 
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }

                //case1: connect and move curr to curr.left
                if(prev.right==null && prev.right!=curr){ 
                    prev.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }//case2: disconnect and move curr to curr.right
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}