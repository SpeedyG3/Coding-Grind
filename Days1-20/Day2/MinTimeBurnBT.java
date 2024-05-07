/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
//CODING NINJAS STRIVER
import java.util.*;
public class Solution{
    public static int findMax(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap, 
    BinaryTreeNode<Integer> target){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        HashMap<BinaryTreeNode<Integer>, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int max = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;
            for(int i=0;i<size;i++){
                BinaryTreeNode<Integer> node = q.poll();
                if(node.left!=null && vis.get(node.left)==null){
                    flag = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right!=null && vis.get(node.right)==null){
                    flag = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
                if(parentMap.get(node)!=null && vis.get(parentMap.get(node))==null){
                    flag = 1;
                    vis.put(parentMap.get(node), 1);
                    q.offer(parentMap.get(node));
                }
            }
            if(flag==1){
                max++;
            }
        }
        return max;
    }
	public static BinaryTreeNode<Integer> markParents(BinaryTreeNode<Integer> root, 
    HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap, int start){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> node = q.poll();
            if(node.data==start){
                res = node;
            }
            if(node.left!=null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
	public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start){
		HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        BinaryTreeNode<Integer> target = markParents(root, parentMap, start);
        //also return the start node with the help of the integer val 
        int maxTime = findMax(parentMap, target);
        return maxTime;
    }
}

//write main