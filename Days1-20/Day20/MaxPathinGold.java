// LC 1219. Path with Maximum Gold - medium 
class Solution {
    public static int dfs(int grid[][], int x, int y, int n, int m){
        if(x<0 || x>=n || y<0 || y>=m || grid[x][y]==0){
            return 0;
        }

        int curr = grid[x][y];
        grid[x][y] = 0; //visited
        int localMax = curr;

        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};

        for(int i=0;i<4;i++){
            int newX = x + dr[i];
            int newY = y + dc[i];

            localMax = Math.max(localMax, curr + dfs(grid, newX, newY, n, m));
        }
        grid[x][y] = curr; //unvisit 
        return localMax;
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    maxGold = Math.max(maxGold, dfs(grid, i, j, n, m));
                }
            }
        }
        return maxGold;
    }
}