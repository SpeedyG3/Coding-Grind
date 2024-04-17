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
//striver 
//my soln basic 
// LC 230. Kth Smallest Element in a BST - medium
class Solution {
    public static void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root!=null){
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        // for(int i: arr){
        //     System.out.print(i+" ");
        // }
        return arr.get(k-1);
    }
}

//striver optimal using morris inorder 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int i = 0;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                i++;
                if(i==k){
                    return curr.val;
                }
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }

                //case1: connect and move curr to curr.left
                if(prev.right==null && prev.right!=curr){ 
                    prev.right = curr;
                    curr = curr.left;
                }//case2: disconnect and move curr to curr.right
                else{
                    prev.right = null;
                    i++;
                    if(i==k){
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}