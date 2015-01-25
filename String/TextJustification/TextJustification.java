/*
Text Justification 

Given an array of words and a length L, format the text such that each line 
has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words 
as you can in each line. Pad extra spaces ' ' when necessary so that each line 
has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is 
inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/
import stringListUtil.*;
import java.util.*;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<>(); 
        if(words.length == 0) return result;     
        int i = 0;   
        while(i < words.length) {   
            int start = i;   
            int sum = 0;   
            while(i<words.length && sum+words[i].length()<=L)   {   
                sum += words[i].length() + 1; // word plus space  
                i++;   
            }   
            int end = i-1;    
            int intervalCount = end - start;   
            int avgSp = 0, leftSp = 0;   
            if(intervalCount > 0) {   
                avgSp = (L-sum + intervalCount+1)/intervalCount;   
                leftSp = (L-sum + intervalCount+1)%intervalCount;   
            }      
            String line = "";      
            for(int j=start;j<end;j++) {   
                line += words[j];   
                if(i == words.length) line += " "; // the last line  
                else {   
                    for(int k=0;k<avgSp;k++) line += " "; //average space  
                    if(leftSp > 0) {// the extra space  
                        line += " ";   
                        leftSp--;   
                    }   
                }   
            }   
            line += words[end];  
            if(line.length() < L) { 
                int m=L-line.length();
                for(int k=0;k<m;k++) line += " "; 
            }
            result.add(line);      
         }   
         return result;   
    }

    public static void main(String args[]){
        String[] words = {"This","is","an","example","of","text","justification."}; //{""};
        int L = 16; //2;
        StringListUtil.printList((new TextJustification()).fullJustify(words,L));
    }
}

