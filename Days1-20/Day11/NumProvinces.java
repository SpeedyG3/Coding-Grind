//Striver a2z lc
//by making adjList basic soln
// LC 547. Number of Provinces - medium 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected[0].length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean vis[] = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i, adjList, vis);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean vis[]){
        vis[node] = true;
        for(int i: adjList.get(node)){
            if(!vis[i]){
                dfs(i, adjList, vis);
            }
        }
    }
}

// a bit better or optimised way 
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected[0].length];
        int count = 0;
        for(int i=0;i<isConnected[0].length;i++){
            if(!vis[i]){
                dfs(vis, isConnected, i);
                count++;
            }
        }
        return count;
        
    }

    public static void dfs(boolean vis[], int[][] isConnected, int node){
        vis[node] = true;
        for(int i=0;i<isConnected[node].length;i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(vis, isConnected, i);
            }
        }
    }
}