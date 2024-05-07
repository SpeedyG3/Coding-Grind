//coding ninjas
//striver a2z graphs
//topo bfs
import java.util.*;
public class Solution {
  public static boolean topologicalSort(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];
        
        // Populate adj and calculate indegrees
        for (ArrayList<Integer> edge : edges) {
            int a = edge.get(0) - 1; // Adjust index to start from 0
            int b = edge.get(1) - 1; // Adjust index to start from 0
            adj.get(a).add(b);
            indegree[b]++;
        }

        int ct = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ct++;

            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        
        // If all nodes were visited, no cycle is detected
        if (ct == n) {
            return false;
        }
        return true; // Cycle detected
    }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    return topologicalSort(edges, n);
  }
}