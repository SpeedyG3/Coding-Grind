/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Write main 

// LC 297. Serialize and Deserialize Binary Tree - hard
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            //dont check and add as we are fine adding null nodes
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        String vals[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        for(int i=1;i<vals.length;i++){
            TreeNode parent = q.poll();
            if(!vals[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                parent.left = left;
                q.add(left);
            }

            if(!vals[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));