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

public class WordLadder1 {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(valid(start,end)) return 2;
        int level = 1, rlevel = 1;
        ArrayDeque<String> wordqueue = new ArrayDeque<String>();
        ArrayDeque<Integer> levqueue = new ArrayDeque<Integer>();
        ArrayDeque<String> rwordqueue = new ArrayDeque<String>();
        ArrayDeque<Integer> rlevqueue = new ArrayDeque<Integer>();
        wordqueue.add(start); levqueue.add(1); 
        rwordqueue.add(end); rlevqueue.add(1);
        Map<String,Boolean> mark = new HashMap<String,Boolean>();
        Map<String,Boolean> rmark = new HashMap<String,Boolean>();
        Iterator<String> it = dict.iterator();
        while(it.hasNext()){
        	String w = it.next(); mark.put(w,false); rmark.put(w,false);
        }
        while(!wordqueue.isEmpty() && !rwordqueue.isEmpty()){
        	if(wordqueue.size() < rwordqueue.size()){
        		while(!wordqueue.isEmpty() && levqueue.peek()==level){
        			Set<String> ldict = findDict(wordqueue.peek(),dict);
        			it = ldict.iterator();
        			while(it.hasNext()){
        				String w = it.next();
        				if(!mark.get(w)){
        					mark.put(w,true);
        					if(rmark.get(w)) 
        						return levqueue.peek()+rlevqueue.peekLast();
        					wordqueue.add(w); levqueue.add(level+1);
        				}
        			}
                    wordqueue.poll(); levqueue.poll(); 
        		}
        		level++;
        	}
        	else{
        		while(!rwordqueue.isEmpty() && rlevqueue.peek()==rlevel){
        			Set<String> rdict = findDict(rwordqueue.peek(),dict);
        			it = rdict.iterator();
        			while(it.hasNext()){
        				String w = it.next();
        				if(!rmark.get(w)){
        					rmark.put(w,true);
        					if(mark.get(w)) 
        						return rlevqueue.peek()+levqueue.peekLast();
        					rwordqueue.add(w); rlevqueue.add(rlevel+1);
        				}
        			}
                    rwordqueue.poll(); rlevqueue.poll(); 
        		}
        		rlevel++;
        	}
        }
        return 0;
    }
    private boolean valid(String st1, String st2){
        boolean flag = false;
        for(int i=0;i<st1.length();i++)
            if(st1.charAt(i) != st2.charAt(i)){
                if(flag) return false;
                else flag = true;
            }
        return true;
    }
    private Set<String> findDict(String str, Set<String> dict){
        Set<String> res = new HashSet<String>();
        for(int i=0;i<str.length();i++){
            char[] s = str.toCharArray();
            for(char c='a';c<='z';c++)
                if(s[i] != c){
                    s[i] = c; String w = new String(s);
                    if(dict.contains(w)) res.add(w);
                }
        }
        return res;
    }
    public static void main(String args[]){
        String start = "hit", end = "cog";
        String[] dic = {"hot","dot","dog","lot","log"}; 
        Set<String> dict = new LinkedHashSet<String>(Arrays.asList(dic));
        System.out.println((new WordLadder1()).ladderLength(start,end,dict)); 
    }
}

/*
Double breadth first search.
Search from both direction. Every time, we search one level from 
the start and one level from the end, the stop condition is found 
one node which has been marked by the other direction.

          O (start)   |
      /   |   \       |
     O    O    O      |
    / \  / \  / \     v
    O  O @ O  O  O   ---
    \ /  \ /  \ /     ^
     O    O    O      |
      \   |   /       |
          O (end)     |
*/