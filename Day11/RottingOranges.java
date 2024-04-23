//Graphs Striver a2z 
// LC 994. Rotting Oranges - medium
class Tuple{
    int row;
    int col;
    int time;
    public Tuple(int r, int c, int t){
        this.row = r;
        this.col = c;
        this.time = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int cntFresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }

                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        int ct = 0;
        int maxTime = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            maxTime = Math.max(maxTime, t);
            q.remove();
            for(int i=0;i<4;i++){
                int neighbouringRow = r + dr[i];
                int neighbouringCol = c + dc[i];
                if(neighbouringRow>=0 && neighbouringRow<n && neighbouringCol>=0 &&
                neighbouringCol<m && vis[neighbouringRow][neighbouringCol]==0 &&
                grid[neighbouringRow][neighbouringCol]==1){
                    q.add(new Tuple(neighbouringRow, neighbouringCol, t+1));
                    vis[neighbouringRow][neighbouringCol] = 2;
                    ct++;
                }
            }
        }

        if(ct!=cntFresh){
            return -1;
        }
        return maxTime;

    }
}