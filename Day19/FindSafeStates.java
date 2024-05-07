//Striver dsa A2Z
//GRAPHS 
// LC 802. Find Eventual Safe States - medium

//DFS (General way )
class Solution {
    public static boolean dfsCheck(int node, List<List<Integer>> adj, int vis[],
     int pathVis[], int check[]){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it, adj, vis, pathVis, check)){
                    return true;
                }
            }else if(pathVis[it]==1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>>adj = new ArrayList<>();
        int v = graph.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int vis[] = new int[v];
        int pathVis[] = new int[v];
        int check[] = new int[v];

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer>safe = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1){
                safe.add(i);
            }
        }
        return safe;
    }
}

//BFS Topo sort 
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //create rev edges to do using TOPO BFS TECHNIQUE
        List<List<Integer>>revAdj = new ArrayList<>();
        int v = graph.length;
        for(int i=0;i<v;i++){
            revAdj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].length;j++){
                revAdj.get(graph[i][j]).add(i);
            }
        }

        int indegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(int it: revAdj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safe = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            safe.add(node);
            for(int it: revAdj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safe);
        return safe;
        
    }
} 