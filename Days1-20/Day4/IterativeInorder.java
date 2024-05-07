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
//using stack iterative inorder traversal ... striver series
// LC 94. Binary Tree Inorder Traversal - easy 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                // check if it's not null
                // Keep adding all the left nodes 
                stack.add(node);
                node = node.left;
            } else{
                // check if stack is empty -> Break
                if(stack.isEmpty()){
                    break;
                }else{
                    // My node == stack.pop()
                    // Print it -> add to list
                    // Check it's right part
                    node = stack.pop();
                    result.add(node.val);
                    node = node.right;
                }
            }
        }
          return result;
    }
}