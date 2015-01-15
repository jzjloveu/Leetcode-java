/*
Excel Sheet Column Number 

Related to question 'Excel Sheet Column Title'

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i=0;i<s.length();i++)
            num = num*26 + s.charAt(i)-'A'+1;
        return num;
    }

    public static void main(String args[]){
        String s = "AZ";
        System.out.println((new ExcelSheetColumnNumber()).titleToNumber(s));
    }
}

/*
In Excel, the range is A~Z, AA~ZZ, AAA~ZZZ. So the problem will be 26-base convert
problem, just notice start from one, so need to plus 1.
*/