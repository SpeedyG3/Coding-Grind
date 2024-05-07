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
// LC  99. Recover Binary Search Tree - medium
// Brute Force
class Solution {
    private int i = 0;
    public static void inorder(TreeNode root, List<Integer> list){
        if(root!=null){
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        solveTree(list, root);
    }

    public void solveTree(List<Integer> list, TreeNode root){
        //doing inorder
        if(root!=null){
            solveTree(list, root.left);
            root.val = list.get(i++);          
            solveTree(list, root.right);
        }
    }
}

//Optimal Soln
//striver 
class Solution {
    private TreeNode prev, first, second, mid;
    public void recoverTree(TreeNode root) {
        prev = first = second = mid = null;
        inorderSoln(root);
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        else if(first!=null && mid!=null){
            int temp =  first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    public void inorderSoln(TreeNode root){
        if(root!=null){
            inorderSoln(root.left);
            if(prev!=null && root.val<prev.val){
                if(first==null){
                    first = prev;
                    mid = root;
                }else{
                    second = root;
                }
            }
            prev = root;
            inorderSoln(root.right);
        }
    }
}