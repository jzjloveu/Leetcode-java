/*
Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/


public class IntegerToRoman {
   
   public String intToRoman(int num) {
        String[] roman = {"I","V","X","L","C","D","M"};
        String result = "";  int scal = 1000;
        for(int i=6;i>=0;i-=2) {
            int digit = num/scal;
            if(digit != 0) { 
                if(digit <= 3) {
                    result += new String(new char[digit]).replace("\0", roman[i]);
                }
                else if(digit == 4) { result += roman[i]+roman[i+1]; }
                else if(digit == 5) { result += roman[i+1]; }
                else if(digit <= 8) { 
                    result += roman[i+1]; 
                    result += new String(new char[digit-5]).replace("\0", roman[i]);
                }
                else if(digit == 9) { result += roman[i]+roman[i+2]; }
            }
            num %= scal; scal /= 10;
        }
        return result;
    }

    public static void main(String args[]){
        int num = 6;
        System.out.println((new IntegerToRoman()).intToRoman(num));
    }
}

/*
Roman number rules(see wiki):
Forms:
I   1
V   5
X   10
L   50
C   100
D   500
M   1000

Idea: 
Need handle every digit in the range of roman number,
1<=digit <=3
digit =4
digit = 5
5<digit<=8
digit =9
*/