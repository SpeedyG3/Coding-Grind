/*
    Time Complexity : O(N^2)
    Space Complexity : O(N)

    Where 'N' is the number of cities.
*/
//striver a2z graphs coding ninjas
//number of connected graphs
public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            // If city 'i' is unvisited then mark all cities connected to it as visited using DFS traversal.
            if (!visited[i]) {
                dfs(i, n, roads, visited);
                // Increase 'COUNT' for each DFS traversal
                count++;
            }
        }
        return count;
    }

    public static void dfs(int p, int n, int[][] roads, boolean[] visited) {
        visited[p] = true;

        for (int i = 0; i < n; i++) {
            if (roads[p][i] == 1 && !visited[i]) {
                dfs(i, n, roads, visited);
            }
        }
    }
}