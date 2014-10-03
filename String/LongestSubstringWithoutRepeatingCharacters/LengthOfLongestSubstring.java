/*
Longest Substring Without Repeating Characters 

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class LengthOfLongestSubstring {
   
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0, rear = 0;
        String substr = "";
        for(int front=0;front<s.length();front++){
            if(substr.indexOf(""+s.charAt(front)) == -1)
                substr += s.charAt(front);
            else{
                maxlen = Math.max(maxlen,substr.length());
                while(s.charAt(rear) != s.charAt(front)) rear++;
                rear++;
                substr = s.substring(rear,front+1); 
            }
        }
        return Math.max(maxlen,substr.length());
    }

    public static void main(String args[]){
        String S = "qpxrjxkltzyx";// "abcabcbb";
        System.out.println((new LengthOfLongestSubstring()).lengthOfLongestSubstring(S));
    }
}

/*
Use two pointer scan string from left to right, when front pointer meet reapt character, we get a max substring length; then start from rear point + 1 to scan over till the end.
Example: 
index   0 1 2 3 4 5 6 7 8 9 10 11 
str     q p x r j x k l t z y  x
1st run ^ ------> ^
2nd run       ^ -------------> ^
3rd run             ^ -------> ^ 
*/

