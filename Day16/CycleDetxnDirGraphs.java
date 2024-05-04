//Coding ninjas 
//striver a2z graph
//dfs algo

import java.util.*;
public class Solution {
    public static boolean dfs(int node, boolean vis[], boolean pathVis[], List<List<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        for(int it: adj.get(node)){
            if(!vis[it]){
                if(dfs(it, vis, pathVis,adj)){
                    return true;
                }
            }else if(pathVis[it]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
    public static Boolean isCyclic(int[][] edges, int v, int e){
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int x = edges[i][0];
            int y = edges[i][1];

            adj.get(x).add(y);
        }

        boolean vis[] = new boolean[v];        
        boolean pathVis[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj)){
                    return true;
                }
            }        
        }
        return false;
	}
}