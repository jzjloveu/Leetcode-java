/*
Add Binary

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/


public class AddBinary {
   
    public String addBinary(String a, String b)  {
        int carry = 0;
        String result = "";
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
			int ai = (i>=0)?a.charAt(i)-'0':0;
            int bi = (j>=0)?b.charAt(j)-'0':0;
			int val = (ai+bi+carry) % 2;
            carry = (ai+bi+carry) / 2;
            result = "" + val +result;
		}
        if(carry == 1)
			result = "1" + result;
        return result;
    }

    public static void main(String args[]){
        String a = "11", b = "1";
        System.out.println((new AddBinary()).addBinary(a,b));
    }
}

