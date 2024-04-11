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
// LC 222. Count Complete Tree Nodes - EASY 
//STRIVER
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

//adcanced soln - ---------------------------------- STRIVER 
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
class Solution { //advanced solution -> less than O(n) Time Complexity 
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        int lh = getLeftHt(root);
        int rh = getRightHt(root);

        if(lh==rh){
            return (int)Math.pow(2, lh) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static int getLeftHt(TreeNode root){
        int ct = 1;
        while(root.left!=null){
            ct++;
            root = root.left;
        }
        return ct;
    }

    public static int getRightHt(TreeNode root){
        int ct = 1;
        while(root.right!=null){
            ct++;
            root = root.right;
        }
        return ct;
    }
}

// tc -> o(logn^2)


//write main 