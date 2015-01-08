/*
Read N Characters Given Read4

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class ReadNCharactersGivenRead4 extends Reader4 {
   /**
    * @param buf Destination buffer
    * @param n   Maximum number of characters to read
    * @return    The number of characters read
    */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = read4(buffer);
            if (sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz); 
            // paramters: src, srcPos, dest, destPos, length
            System.arraycopy(buffer, 0, buf, readBytes, bytes);
            readBytes += bytes;
        }
        return readBytes;
    }
}

    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        System.out.println((new ReadNCharactersGivenRead4()).read(s,3));
    }
}
/*
n is not always the number of multiple 4, and buff length may less than 4.
*/
