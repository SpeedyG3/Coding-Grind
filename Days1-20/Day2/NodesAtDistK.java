/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// LC 863. All Nodes Distance K in Binary Tree - medium 
//STRIVER 
class Solution {
    public static void markParents(HashMap<TreeNode, TreeNode> parentMap, TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(parentMap, root);
        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        vis.put(target, true);
        int currLvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLvl==k){
                break;
            }
            currLvl++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.offer(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.offer(curr.right);
                    vis.put(curr.right, true);
                }
                if(parentMap.get(curr)!=null && vis.get(parentMap.get(curr))==null){
                    q.offer(parentMap.get(curr));
                    vis.put(parentMap.get(curr), true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }
}

//write main to run and check