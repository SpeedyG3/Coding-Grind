//number of islands - all 8 directions
//GFG -> https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
//Striver video ->  https://www.youtube.com/watch?v=muncqlKJrH0
//graphs
//using bfs
//can also do with dfs
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    
    public Pair(int r, int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    // Function to find the number of islands.
    public void bfs(int r, int c, boolean[][] vis, char[][]grid){
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        
        int n = grid.length;
        int m = grid[0].length;
        
        int dr[] = {-1, -1, -1, 0, +1, +1, +1, 0};
        int dc[] = {-1, 0, +1, +1, +1, 0, -1, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<8;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]
                && grid[nrow][ncol]=='1'){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int ct = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(!vis[r][c] && grid[r][c]=='1'){
                    ct++;
                    bfs(r, c, vis, grid);
                }
            }
        }
        
        return ct;
    }
}