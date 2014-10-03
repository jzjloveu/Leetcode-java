/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
 

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return null;
        if (s.length() == 1) return s;
        String longest = s.substring(0, 1);
    	for (int i = 0; i < s.length(); i++) {
    		// get longest palindrome with center of i
    		String tmp = helper(s, i, i);
    		if (tmp.length() > longest.length()) longest = tmp;
            // get longest palindrome with center of i, i+1
    		tmp = helper(s, i, i + 1);
    		if (tmp.length() > longest.length()) longest = tmp;
    	}
        return longest;
    }
 
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
    	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
    		begin--;
    		end++;
    	}
    	return s.substring(begin + 1, end);
    }

    public static void main(String args[]){
        //String s = "aaa";//"abccb";
String s =        "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        System.out.println((new LongestPalindrome()).longestPalindrome(s));
    }
}

/*
This is a simple alogritm. get longest palindrome with center of i or i + 1.
Time O(n^2), Space O(1).
Reference: http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
*/