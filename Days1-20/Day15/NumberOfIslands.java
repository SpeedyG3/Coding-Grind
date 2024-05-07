// LC 200. Number of Islands - MEDIUM
// striver a2z sheet  (present in one of the links) 
//grapsh
class Solution {
    public static void dfs(char grid[][], boolean vis[][], int n, int m, int r, int c){
        vis[r][c] = true;
        int dr[] = {0, +1, 0, -1};
        int dc[] = {+1, 0, -1, 0};
        for(int i=0;i<4;i++){
            int nrow = r + dr[i];
            int ncol = c + dc[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]
            && grid[nrow][ncol]=='1'){
                dfs(grid, vis, n, m, nrow, ncol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int ct = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    ct++;
                    dfs(grid, vis, n, m, i, j);
                }
            }
        }
        return ct;
    }
}