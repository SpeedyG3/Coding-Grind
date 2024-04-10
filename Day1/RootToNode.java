import java.util.*;
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int v){
        this.val = v;
    }
}

public class RootToNode{

    public static void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val);
            inorder(root.right);
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

    public static void allPaths(TreeNode root, ArrayList<String> paths, String s){
        if(root==null){
            return;
        }

        s += root.val+" ";
        if(root.left==null && root.right==null){
            paths.add(s);
            return;
        }

        if(root.left!=null){
            allPaths(root.left, paths, s);
        }
        if(root.right!=null){
            allPaths(root.right, paths, s);
        }
    }

    public static void main(String args[]){
        TreeNode root1 = buildTree();
        inorder(root1);

        ArrayList<String> paths = new ArrayList<>();
        System.out.println();
        allPaths(root1, paths, "");
        for(String s: paths){
            System.out.print(s+" ");
        }
    }
}