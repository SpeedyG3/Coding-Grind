//striver a2z sheet -> one of the links 
//graphs bfs
// Distinct Islands (coding ninjas) -> https://www.naukri.com/code360/problems/distinct-islands_630460?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
import java.util.*;
public class Solution {
	public static void dfs(int arr[][], boolean vis[][], int n, int m, int r, int c, int baseR, int baseC,
	 ArrayList<ArrayList<Integer>> list){
		vis[r][c] = true;
		ArrayList<Integer> a = new ArrayList<>();
		a.add(r-baseR);
		a.add(c-baseC);
		int dr[] = {0, +1, 0, -1};
		int dc[] = {+1, 0, -1, 0};
		list.add(new ArrayList(a));
		for(int i=0;i<4;i++){
			int nrow = r + dr[i];
			int ncol = c + dc[i];

			if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && arr[nrow][ncol]==1){
				dfs(arr, vis, n, m, nrow, ncol, baseR, baseC, list);
			}
		}
	}

	public static int distinctIsland(int [][] arr, int n, int m) {
		boolean vis[][] = new boolean[n][m];
		Set<ArrayList<ArrayList<Integer>>> s = new HashSet<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(!vis[i][j] && arr[i][j]==1){
					ArrayList<ArrayList<Integer>> list = new ArrayList<>();
					dfs(arr, vis, n, m, i, j, i, j, list);
					s.add(list);
				}
			}
		}

		return s.size();
	}
}
