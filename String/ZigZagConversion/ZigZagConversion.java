// ZigZag Conversion 
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a 
given number of rows like this: (you may want to display this 
pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion 
given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class ZigZagConversion {
   
    public String convert(String s, int nRows) {
        if(s==null) return null;
        int sz = s.length();
        
        if(nRows<=1) return s;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<nRows; i++) {
            int j=i;
            while(j<sz) {
                sb.append( s.charAt(j) );
                
                if( (i% (nRows-1)) != 0) {
                    int k = j + (nRows-1-i)*2;         //define new int k and save the old value in j for next loop
                    if(k<sz) sb.append(s.charAt(k) );  //must check k<sz; may be exceed string length.
                }
                j+=2*(nRows-1);
            }
        } 
        return sb.toString();
    }

    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        System.out.println((new ZigZagConversion()).convert(s,3));
    }
}
