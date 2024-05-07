//coding ninjas striver graph
//using DFS technique
// Topo Sort

import java.util.*;
public class Solution {
    public static void dfs(int node, boolean vis[], Stack<Integer> s, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, s, adj);
            }
        }
        s.push(node);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            adj.get(a).add(b);
        }

        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i, vis, s, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
        return ans;
    }

}