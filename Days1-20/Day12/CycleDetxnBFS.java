//striver a2z coding ninjas
//bfs cycle detection - medium

import java.util.*;

class Pair{
    int on;
    int parent;

    public Pair(int o, int p){
        this.on = o;
        this.parent = p;
    }
}
public class Solution {
    static class Graph {

        public boolean checkForCycle(int src, int V, List<List<Integer>> adj, boolean vis[]){
            vis[src] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(src, -1));
            while(!q.isEmpty()){
                int node = q.peek().on;
                int cameFrom = q.peek().parent;
                q.remove();

                for(int adjacentNode: adj.get(node)){
                    if(vis[adjacentNode]==false){
                        vis[adjacentNode]=true;
                        q.add(new Pair(adjacentNode, node));
                    }else if(cameFrom!=adjacentNode){
                        return true;
                    }
                }
            }
            return false;
        }
        boolean detectCycle(int V, List<List<Integer>> adj) {
            // Write your code here.
            boolean vis[] = new boolean[V];
            for(int i=0;i<V;i++){
                vis[i] = false;
            }

            for(int i=0;i<V;i++){
                if(vis[i]==false){
                    if(checkForCycle(i, V, adj, vis)){
                        return true;
                    }
                }
            }
            return false;
        }
    };
}
