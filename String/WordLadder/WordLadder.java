/*
Word Ladder

Given two words (start and end), and a dictionary, find the length of shortest 
transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
import java.util.*;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict.size() == 0) return 0; 
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        dict.add(end); wordQueue.add(start); distanceQueue.add(1);
        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop(); 
            Integer currDistance = distanceQueue.pop(); 
            if(currWord.equals(end)){ return currDistance; }
            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a';c<='z';c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord); 
                        distanceQueue.add(currDistance+1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]){
        String start = "hit", end = "cog";
        String[] dic = {"hot","dot","dog","lot","log"}; 
        Set<String> dict = new LinkedHashSet<String>(Arrays.asList(dic));
        System.out.println((new WordLadder()).ladderLength(start,end,dict)); 
    }
}

/*
Using Breath First Search.
A tree breadth first search guarantees the optimal solution.
*/