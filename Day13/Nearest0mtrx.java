// LC 542. 01 Matrix
// Striver A2Z also discussed the same question 
// 0/1 Matrix (Bfs Problem) - graphs
class Node{
    int x;
    int y;
    int dist;

    public Node(int a, int b, int d){
        this.x = a;
        this.y = b;
        this.dist = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};

        //n x m x 4
        while(!q.isEmpty()){
            int row = q.peek().x;
            int col = q.peek().y;
            int step = q.peek().dist;
            q.poll();
            dist[row][col] = step;
            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.add(new Node(nrow, ncol, step+1));
                }
            }
        }
        return dist;
    }
}