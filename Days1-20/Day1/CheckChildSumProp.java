/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
// Check for Children Sum Property (striver a2z dsa and coding ninjas)
// same as 2236. Root Equals Sum of Children - easy 
public class CheckChildSumProp{
    public static boolean isParentSum(Node root) {
        if(root==null){
            return true;
        }

        if(root.left==null && root.right==null){
            return true;
        }

        if(root.left==null){
            return isParentSum(root.right) && root.data==root.right.data;
        }

        if(root.right==null){
            return isParentSum(root.left) && root.data==root.left.data;
        }

        return isParentSum(root.right) && isParentSum(root.left) && 
        root.data == root.left.data + root.right.data;
    }
}

//write main and imports