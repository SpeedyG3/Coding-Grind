// import org.graalvm.compiler.graph.Node;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
//Finding the largest BST in a BT
//Coding ninjas 
//Striver optimal
import java.util.*;
class NodeValue{
    public int minNode, maxNode, maxSize;
    public NodeValue(int min, int max, int size){
        this.minNode = min;
        this.maxNode = max;
        this.maxSize = size;
    }
}
public class Solution {
    public static NodeValue largestBstHelper(TreeNode root) {
        // Empty BST has size = 0
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        //get values from left and right subtree
        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        //current is greater than max in left and smaller than min in right 
        if(left.maxNode<root.data && right.minNode>root.data){
            //it is a BST
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
            1+left.maxSize+right.maxSize);
        }

        //otherwise return [-inf, inf] so that the parent can't be a valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static int largestBST(TreeNode root){
        return largestBstHelper(root).maxSize;
    }
}