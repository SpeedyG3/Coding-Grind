// LC 506. Relative Ranks - easy 
// Simple default method 
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] sortedPairs = new int[n][2];
        for (int i = 0 ; i < n ; i++) sortedPairs[i] = new int[] {i, score[i]};
        
        Arrays.sort(sortedPairs, (x, y) -> (y[1] - x[1]));
        String[] ans = new String[n];
        for (int i = 0 ; i < n ; i++) {
            if (i == 0) {
                ans[sortedPairs[i][0]] = "Gold Medal";
            } else if (i == 1) {
                ans[sortedPairs[i][0]] = "Silver Medal";
            } else if (i == 2) {
                ans[sortedPairs[i][0]] = "Bronze Medal";
            } else {
                ans[sortedPairs[i][0]] = String.valueOf(i+1);
            }
        }
        return ans;
    }
}

// Good optimised method -> priority queue descending (max heap)
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        PriorityQueue<Pair<Integer, Integer>> maxheap = 
        new PriorityQueue<>((p1, p2) -> (p2.getValue() - p1.getValue()));
        for (int i = 0 ; i < n ; i++) {
            maxheap.add(new Pair(i, score[i]));
        }
        
        String[] ans = new String[n];
        int place = 1;
        while (!maxheap.isEmpty()) {
            Pair<Integer, Integer> top = maxheap.poll();
            int curIndex = top.getKey();
            if (place == 1) {
                ans[curIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[curIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[curIndex] = "Bronze Medal";
            } else {
                ans[curIndex] = String.valueOf(place);
            }
            place++;
        }
        
        return ans;
    }
}