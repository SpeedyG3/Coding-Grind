// LC 130. Surrounded Regions - medium 
//Striver A2Z sheet - graphs
//can do with DFS and BFS
//dfs
class Solution {
    public static void dfs(int row, int col, char board[][], boolean vis[][], int dr[], int dc[]){
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length
            && !vis[nrow][ncol] && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, board, vis, dr, dc);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        int dr[] = {0, +1, 0, -1};
        int dc[] = {-1, 0, +1, 0};
        for(int i=0;i<n;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i, 0, board, vis, dr, dc);
            }

            if(!vis[i][m-1] && board[i][m-1]=='O'){
                dfs(i, m-1, board, vis, dr, dc);
            }
            
        }

        for(int j=0;j<m;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0, j, board, vis, dr, dc);
            }

            if(!vis[n-1][j] && board[n-1][j]=='O'){
                dfs(n-1, j, board, vis, dr, dc);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}