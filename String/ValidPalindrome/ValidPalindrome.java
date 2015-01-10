// Valid Palindrome

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome. 

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s.length() < 2){return true;}
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int end = str.length()-1;
        int front = 0;
        while(front < end){
        	if(str.charAt(front++) != str.charAt(end--))
			   return false;
        }
        return true;
    }
    
    public static void main(String args[]){
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println("\""+str1+"\"");
        System.out.println(sol.isPalindrome(str1));
        System.out.println("\""+str2+"\"");
        System.out.println(sol.isPalindrome(str2));
    }
}

/*
Dynamic programming. First use isPal to record each substring is palindrome or not. "isPal[i][j] == true" means a substring starts from s[i] (included) to s[j] (included) is a palindrome. Then use DFS.
*/
