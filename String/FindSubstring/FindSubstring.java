/*
Substring with Concatenation of All Words

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
import java.util.*;

public class FindSubstring {
   
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        int num = L.length, wlen = L[0].length();
        if(num == 0) return result;
        for(int i=0;i<S.length()-num*wlen+1;i++){
            ArrayList<String> slist = new ArrayList<String>();
            for(int j=i;j<i+num*wlen;j+=wlen)  slist.add(S.substring(j,j+wlen));
            boolean found = true;
            for(String word:L){
                if(slist.contains(word)) slist.remove(word);
                else{found = false; break;}
            }
            if(found) result.add(i);
        }
        return result;
    }

    private static void printlist(ArrayList<String> list){
        System.out.print("{ ");
        for(int i=0;i<list.size();i++){
            if(i<list.size()-1) System.out.print(list.get(i)+",");
            else System.out.print(list.get(i));
        }
        System.out.print("}\n"); 
    }

    public static void main(String args[]){
        String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";//"barfoothefoobarman";
        String[] L = {"fooo","barr","wing","ding","wing"};//{"foo", "bar"};
        List<Integer> res = (new FindSubstring()).findSubstring(S,L);
        System.out.print("[");
        for(int i=0;i<res.size();i++){
            if(i<res.size()-1) System.out.print(res.get(i)+",");
            else System.out.print(res.get(i));
        }
        System.out.print("]\n");   
    }
}

/*
Say in L there are m strings with length n. 
What string is required to match in S?     A length of m*n string start with each position in S.
What is a match?  In the m*n long string, every string in L appear only once.

So the algorithm is:
Scan every m*n long string start from each position in S, see if all the strings in L have been appeared only once using Map data structure. If so, store the starting position.
*/

