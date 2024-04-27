// Coding ninjas
// Cycle Detection using DFS
//Striver A2Z sheet
import java.util.*;

class Pair {
    int node;
    int parent;

    public Pair(int n, int p) {
        this.node = n;
        this.parent = p;
    }
}

public class Solution {
    static class Graph {

        boolean dfs(int node, int parent, boolean vis[], List<List<Integer>> adj) {
            vis[node] = true;
            for (int adjNode : adj.get(node)) {
                if (!vis[adjNode]) {
                    if (dfs(adjNode, node, vis, adj)) {
                        return true;
                    }
                } else if (adjNode != parent) {
                    return true;
                }
            }
            return false; // Return false if no cycle is found in this connected component
        }

        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean vis[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) { // Check for unvisited nodes
                    if (dfs(i, -1, vis, adj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
