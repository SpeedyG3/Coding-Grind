// lc 1020. Number of Enclaves - MEDIUM 
//Striver A2Z graphs 
//can do wth dfs and bfs
// same as surrounded regions - leetcode
//bfs 
class Pair{
    int row;
    int col;

    public Pair(int r, int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!vis[i][0] && grid[i][0]==1){
                vis[i][0] = true;
                q.add(new Pair(i, 0));
            }

            if(!vis[i][m-1] && grid[i][m-1]==1){
                vis[i][m-1] = true;
                q.add(new Pair(i, m-1));
            }
        }

        for(int j=0;j<m;j++){
            if(!vis[0][j] && grid[0][j]==1){
                vis[0][j] = true;
                q.add(new Pair(0, j));
            }

            if(!vis[n-1][j] && grid[n-1][j]==1){
                vis[n-1][j] = true;
                q.add(new Pair(n-1, j));
            }
        }

        int dr[] = {0, +1, 0, -1};
        int dc[] = {+1, 0, -1, 0};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }

    
}
//dfs
class Solution {
    public static void dfs(int row, int col, int grid[][], boolean vis[][], int dr[], int dc[]){
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length
            && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(nrow, ncol, grid, vis, dr, dc);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int ans = 0;
        int dr[] = {0, +1, 0, -1};
        int dc[] = {+1, 0, -1, 0};
        for(int i=0;i<n;i++){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(i, 0, grid, vis, dr, dc);
            }

            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i, m-1, grid, vis, dr, dc);
            }
        }

        for(int j=0;j<m;j++){
            if(!vis[0][j] && grid[0][j]==1){
                dfs(0, j, grid, vis, dr, dc);
            }

            if(!vis[n-1][j] && grid[n-1][j]==1){
                dfs(n-1, j, grid, vis, dr, dc);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
