//Striver A2Z DSA - graph
// LC 785. Is Graph Bipartite?
class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){ //0 is initial color passed
                if(!dfs(i, 0, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int node, int c, int color[], int graph[][]){
        color[node] = c;
        //c is color of node 
        for(int i: graph[node]){
            if(color[i]==-1){
                if(!dfs(i, 1-c, color, graph)){
                    return false;
                }
            }else if(color[i]==c){
                return false;
            }
        }
        return true;
    }
}