/*
Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class PalindromeNumber1 {

    public boolean isPalindrome(int x) {
        if(x < 0){return false;}
        String numstr = "" + x;
        int front = 0, end = numstr.length()-1;
        while(front < end)
            if(numstr.charAt(front++) != numstr.charAt(end--))
                return false;
        return true;
    }
    
    public static void main(String args[]){
        int x = 12321;
        PalindromeNumber1 sol = new PalindromeNumber1();
	    System.out.println(sol.isPalindrome(x));
    }
}

/*
Dynamic programming. First use isPal to record each substring is palindrome or not. "isPal[i][j] == true" means a substring starts from s[i] (included) to s[j] (included) is a palindrome. Then use DFS.
*/
