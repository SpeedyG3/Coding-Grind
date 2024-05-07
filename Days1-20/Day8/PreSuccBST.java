/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
	
//striver optimised
// medium - coding ninjas
// Inorder Successor/Predecessor in BST
import java.util.*;
public class Solution {
    public static void getSucessor(List<Integer> ans, TreeNode root, int key){
        TreeNode temp = root;
        TreeNode succ = null;
        while(temp!=null){
            if(temp.data<=key){
                temp=temp.right;
            }else{
                succ = temp;
                temp = temp.left;
            }
        }
        if(succ==null){
            ans.add(-1);
            return;
        }else{
            ans.add(succ.data);
            return;
        }
    }

    public static void getPredecessor(List<Integer> ans, TreeNode root, int key){
        TreeNode temp = root;
        TreeNode pred = null;
        while(temp!=null){
            if(temp.data<key){
                pred = temp;
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        if(pred==null){
            ans.add(-1);
            return;
        }else{
            ans.add(pred.data);
            return;
        }
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        getPredecessor(ans, root, key);
        getSucessor(ans, root, key);
        return ans;
    }
}