/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there 
exists one unique longest palindromic substring.
*/
 

public class LongestPalindrome2 {

    public String longestPalindrome(String s) {
        boolean[][] subP = new boolean[s.length()][s.length()];
        int maxlen = 0, start = 0, end = 0;
        for(int j=0;j<s.length();j++){
            for(int i=0;i<j;i++){
                subP[i][j] = s.charAt(i)==s.charAt(j) && (j==i+1 || subP[i+1][j-1]); 
                if(subP[i][j] && maxlen<j-i+1){
                    maxlen  = j-i+1;
                    start = i;
                    end = j;
                }
            }
            subP[j][j] = true;
        }
        return s.substring(start,end+1);
    }
    
    public static void main(String args[]){
        //String s = "aaa";//"abccb";
        String s1="nypdmqqgauepeyfvwcdpbmmaxfwxmmtswfuwldtvqcisywalfnvovuordczxlyzqmslxil"+
        "pnenbuwbcpebneovitwkkswsijajnkwkfbxnulmwotgrmpklntfyjavccbrgwqynryeoswmhsq"+
        "zcwnudkuvfkikjxjkjpghsytjfkpvkjpvblamdeegeohospporbtorkbuggbawgodhxpscfksj"+
        "birxvjyjapwwushmnqsxktnslvonlwvuseinrmwvfqjgzpkwcqfzfdbbmcngmsoeegudwjvldq"+
        "maomwbqvijesnpxiqvtfeiqebrfjhtvjdwkopyfzaslewdjnkmalvfinbuouwcgnfecjtdzwyc"+
        "xrynxepbcsroyzrsgiiuaszvatwyuxinwhni";
        String s2 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedands"+
        "odedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecome"+
        "todedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavethe"+
        "irlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddot"+
        "hisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthis"+
        "groundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfarabove"+
        "ourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwh"+
        "atwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertob"+
        "ededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonob"+
        "lyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbefor"+
        "eusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichthe"+
        "ygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadsh"+
        "allnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedoman"+
        "dthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println((new LongestPalindrome2()).longestPalindrome(s1));
        System.out.println((new LongestPalindrome2()).longestPalindrome(s2));
    }
}

/*
This is a DP problem. According to http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
table[i][j] saves if the string start from i ends at j is the Palindromic string.

Initial state:
table[i][i] =  true.
table[i][i+1] = (s[i]==s[i+1]);

State Change:
if s[i]==s[j], table[i][j]=table[i+1][j-1];

More idea detail:
define a relation,
P[i,j] = string area [i,j] whether is palindrome.

look at an example: S="abccb",
  S   = a  b  c  c  b
Index = 0  1  2  3  4

P[0,0] = true  //each char is a palindrome
P[0,1] = S[0]==S[1],   P[1,1] = true 
P[0,2] = S[0]==S[2] && P[1,1], P[1,2] = S[1]==S[2] , P[2,2] = true
P[0,3] = S[0]==S[3] && P[1,2], P[1,3] = S[1]==S[3] && P[2,2] ,P[2,3]= S[2]==S[3], P[3,3] = true       
...
so we can find the rule as follow:

P[i,j] = true  if i == j
       = S[i]==S[j]   if j == i+1
       = S[i]==S[j] && P[i+1][j-1]  if j > i+1

Manacher’s algorithm:
http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
*/
