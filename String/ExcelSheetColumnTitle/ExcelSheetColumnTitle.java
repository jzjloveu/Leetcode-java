/*
Excel Sheet Column Title 

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0){
            int rem = n % 26; 
            n /= 26;
            if(rem == 0){ res.append('Z'); n--; }
            else res.append((char)(rem+'A'-1));
        }
        return res.reverse().toString();
    }

    public static void main(String args[]){
        int n = 52;
        System.out.println((new ExcelSheetColumnTitle()).convertToTitle(n));
    }
}

/*
In Excel, the range is A~Z, AA~ZZ, AAA~ZZZ. So the problem will be 26-base convert
problem, mod 26 every time, and if remainder is zero, needs to num - 1.
*/