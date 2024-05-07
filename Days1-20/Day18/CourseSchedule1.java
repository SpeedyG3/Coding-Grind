//STRIVER DSA A2Z SHEET
// GRAPHS BFS CYCLE DETECTION (TOPO SORT)
// LC 207. Course Schedule - medium
//can also do with dfs cycle detection for dir graph
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj.get(a).add(b);
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

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add(node);

            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        if(topo.size()==numCourses){
            return true; 
        }
        return false;
    }
}