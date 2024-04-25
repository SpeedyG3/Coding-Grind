// Striver a2z graphs (dsa)
// LC 733. Flood Fill - easy
class Solution {
    public static void dfs(int row, int col, int ans[][], int image[][], int newColor,
     int dr[], int dc[], int iniColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
            image[nrow][ncol]==iniColor && ans[nrow][ncol]!=newColor){
                dfs(nrow, ncol, ans, image, newColor, dr, dc, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int ans[][] = image;
        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, dr, dc, iniColor);
        return ans;
    }
}