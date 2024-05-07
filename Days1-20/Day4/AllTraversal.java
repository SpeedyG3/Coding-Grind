//CODING NINJAS 
//STRIVER JAVA HARD 
// ALL TRAVERSALS IN ONE GO
import javafx.util.Pair;
import java.util.*;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Lists to store traversals
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        // If the tree is empty,
        // return empty traversals
        if (root == null) {
            return new ArrayList<>();
        }

        // Stack to maintain nodes
        // and their traversal state
        Stack<Pair<TreeNode, Integer>> st = new Stack<>();

        // Start with the root node
        // and state 1 (preorder)
        st.push(new Pair<>(root, 1));

        while (!st.empty()) {
            Pair<TreeNode, Integer> it = st.pop();

            // this is part of pre
            if (it.getValue() == 1) {
                // Store the node's data
                // in the preorder traversal
                pre.add(it.getKey().data);
                // Move to state 2
                // (inorder) for this node
                st.push(new Pair<>(it.getKey(), 2));

                // Push left child onto
                // the stack for processing
                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            }

            // this is a part of in
            else if (it.getValue() == 2) {
                // Store the node's data
                // in the inorder traversal
                in.add(it.getKey().data);
                // Move to state 3
                // (postorder) for this node
                st.push(new Pair<>(it.getKey(), 3));

                // Push right child onto
                // the stack for processing
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }

            // this is part of post
            else {
                // Store the node's data
                // in the postorder traversal
                post.add(it.getKey().data);
            }
        }

        // Returning the traversals
        List<List<Integer>> result = new ArrayList<>();
        result.add(in);
        result.add(pre);
        result.add(post);
        return result;
    }
}
