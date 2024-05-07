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

// LC 106. Construct Binary Tree from Inorder and Postorder Traversal - medium
//not very clear
//striver 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length-1, inorder, 0, 
        inorder.length-1, inMap);

        return root;
    }

    public static TreeNode buildTree(int postorder[], int preStart, int preEnd, int inorder[], 
    int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[preEnd]);

        int inRoot = inMap.get(root.val); //index of root in inorder 
        int numsLeft = inRoot - inStart;

        root.left = buildTree(postorder, preStart, preStart+numsLeft-1, inorder, inStart, 
        inRoot-1, inMap);
        root.right = buildTree(postorder, preStart+numsLeft, preEnd-1, inorder, inRoot+1, 
        inEnd, inMap);

        return root;
    }
}