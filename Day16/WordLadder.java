//Striver dsa
//leetcode 
//Graphs BFS
// LC 127 WORD LADDER - MEDIUM

class Pair{
    String first;
    int second;
    
    Pair(String f, int s){
        this.first = f;
        this.second = s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}