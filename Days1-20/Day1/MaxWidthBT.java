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
// LC 662. Maximum Width of Binary Tree - medium 
class Pair{
    TreeNode node;
    int num;

    public Pair(TreeNode _node, int _num){
        this.node = _node;
        this.num = _num;
    }
}

class MaxWidthBT {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root==null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num; //id to start from 0
            int first = 0, last = 0;
            for(int i=0;i<size;i++){
                int currIdx = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0){
                    first = currIdx;
                }
                if(i==size-1){
                    last = currIdx;
                }

                if(node.left!=null){
                    q.offer(new Pair(node.left, currIdx*2+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, currIdx*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}

//write main and run 