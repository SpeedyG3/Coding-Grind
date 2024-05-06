//STRIVER DSA A2Z SHEET
// GRAPHS BFS CYCLE DETECTION (TOPO SORT)
// LC 210. Course Schedule II - medium
// variant of lc 207 course Schedule I - medium
//can also do with dfs cycle detection for dir graph
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj.get(b).add(a);
        }

        int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int i = 0;
        int topo[] = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo[i] = node;
            i++;

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        if(i==numCourses){
            return topo;
        }
        return new int[]{};
    }
}

