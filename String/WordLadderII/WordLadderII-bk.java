/*
Word Ladder II

Given two words (start and end), and a dictionary, find all shortest 
transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
import java.util.*;
import arrayUtil.*;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
    }
    
    public static void main(String args[]){
        String start = "hit", end = "cog";
        String[] dic = {"hot","dot","dog","lot","log"}; 
        Set<String> dict = new LinkedHashSet<String>(Arrays.asList(dic));
        ArrayListUtil.printListList((new WordLadderII()).findLadders(start,end,dict)); 
    }
}

/*
Using Breath First Search. 
For each words in the BFS queue, we still need to use the previous way to 
generate the valid words in the dicts (from 1st to last, change every char 
from 'a' to 'z' ).
Duplicates is permitted within a level. e.g.,
hem -> hex -> tex -> ted
hem->  tem -> tex -> ted,  are all valid paths.
Draw this into a tree structure:
        hem
       /   \
     hex    tem
      |      |
     tex    tex
      |      |
     ted    ted
A solution is to erase all the words in the previous level, 
instead of erasing words for each word in the level.
Use a map to store and retrieve the paths, stores all the previous strings 
for current string. Retrieval of the path will need recursion (DFS).
*/