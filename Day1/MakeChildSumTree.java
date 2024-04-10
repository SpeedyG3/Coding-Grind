//discussed in striver - HARD
//not available in coding ninjas 
//only video, vid link -> https://www.youtube.com/watch?v=fnmisPM6cVo
import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int v){
        this.val = v;
    }
}
public class MakeChildSumTree{
    public static void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }

    public static void make(TreeNode root){
        if(root==null){
            return;
        }

        int child = 0;
        if(root.left!=null){
            child += root.left.val;
        }

        if(root.right!=null){
            child += root.right.val;
        }

        if(child>=root.val){
            root.val = child;
        }else{
            if(root.left!=null){
                root.left.val = root.val;
            }if(root.right!=null){
                root.right.val = root.val;
            }
        }

        make(root.left);
        make(root.right);

        int total = 0;
        if(root.left!=null){
            total += root.left.val;
        }

        if(root.right!=null){
            total += root.right.val;
        }

        if(root.right!=null || root.left!=null){
            root.val = total;

        }
    }

    public static TreeNode buildTree(){
        TreeNode root = null;
        //enter root val
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(!s.equals("n")){
            root = new TreeNode(Integer.valueOf(s));
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            //enter left child 
            String leftChild = sc.next();
            if(!leftChild.equals("n")){
                curr.left = new TreeNode(Integer.valueOf(leftChild));
                q.offer(curr.left);
            }

            //enter right child 
            String rightChild = sc.next();
            if(!rightChild.equals("n")){
                curr.right = new TreeNode(Integer.valueOf(rightChild));
                q.offer(curr.right);
            }
        }
        return root;
    }

    public static void main(String args[]){
        TreeNode root1 = buildTree();
        inorder(root1);
        System.out.println();
        make(root1);
        inorder(root1);
        System.out.println();
    }
}