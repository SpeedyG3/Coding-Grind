import java.util.*;
//coding ninjas striver sheet weird question check again 
// https://www.naukri.com/code360/problems/creating-and-printing_1214551?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SOLUTION
// Graph Representation | Java
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Write your code here.
        List<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        //undirected unit wt edges

        //HAVE TO GET NEIGHBOURS BASICALLY
        int[][] adjacencyList = new int[n][];
        for(int i=0;i<n;i++){
            int graphSize = graph[i].size();
            int temp[] = new int[graphSize+1];
            temp[0] = i;

            for(int j=0;j<graphSize;j++){
                temp[j+1] = graph[i].get(j);
            }

            adjacencyList[i] = temp;
        }
        return adjacencyList;
    }
}