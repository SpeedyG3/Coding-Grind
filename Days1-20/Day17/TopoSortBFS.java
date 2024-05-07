//
import java.util.*;
public class Solution {
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

        int indegree[] = new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}