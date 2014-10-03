// Minimum Window Substring 

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

//For example, 
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".

//Note:
//If there is no such window in S that covers all characters in T, return the emtpy string "".

//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class MinWindow {
   
    public String minWindow(String S, String T) {
        if(S.length() == 0) return "";  
        if(S.length() < T.length()) return "";            
        int[] appearCount = new int[256];  
        int[] expectCount = new int[256];  
        for(int i =0; i < T.length(); i++)  
             expectCount[(int)T.charAt(i)]++;                 
        int minV = Integer.MAX_VALUE, minStart = 0;  
        int winStart=0;  
        int appeared = 0;   
        for(int winEnd = 0; winEnd< S.length(); winEnd++) {  
              // this char is a part of T 
              if(expectCount[(int)S.charAt(winEnd)] > 0) {  
                   appearCount[(int)S.charAt(winEnd)]++;  
                   if(appearCount[(int)S.charAt(winEnd)] <= expectCount[(int)S.charAt(winEnd)])  
                        appeared++;                      
              }  
              if(appeared == T.length())  {                 
                   while(appearCount[(int)S.charAt(winStart)] > expectCount[(int)S.charAt(winStart)] || expectCount[(int)S.charAt(winStart)] == 0) {  
                        appearCount[(int)S.charAt(winStart)]--;  
                        winStart++;  
                   }                      
                   if(minV > (winEnd - winStart +1)) {  
                        minV = winEnd - winStart +1;  
                        minStart = winStart;  
                   }  
              }                 
        }  
        if(minV == Integer.MAX_VALUE) return "";  
        return S.substring(minStart, minStart+minV);   
    }

    public static void main(String args[]){
        String S = "ADOBECODEBANC";
		String T = "ABC";
        System.out.println((new MinWindow()).minWindow(S,T));
    }
}
/*
The idea is like this:
   We have two pointers, p and q.  S[p:q] stores the string covers all the chars in T. We want minimum p:q.
   Start from the whole S, p=0, q=S.size()-1,  if it cannot cover T, return "";
   Fix p, try to move q close to p, but keep the requirement S[p:q] covers T.
   Find the shortest p:q, here exactly is 1:q, where S[1:q] covers T.
   Move p and q dynamically:
        if  S[p] is irrelevant char, p++;
        if  S[p] is char in T, must move q to left until find S[q]==S[p] to keep the requirement, or q is last.
            When move q to left, if S[q] is in T, store the S[q] occurrence.
   Every move, compare the length p:q store the minimum length and position.
*/
