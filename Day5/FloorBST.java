//striver easy 
//floor of a bst 
//coding ninjas
import java.util.*;

public class solution {
	public static int Floor(BinaryTreeNode<Integer> root, int input) {
		int floor = Integer.MAX_VALUE;
		if(root==null){
			return floor;
		}

		while(root!=null){
			if(root.data==input){
			return input;
			}

			if(root.data<=input){
				floor = root.data;
				root = root.right;
			}

			if(root.data>input){
				root = root.left;
			}
		}
		return floor;
	}
}
