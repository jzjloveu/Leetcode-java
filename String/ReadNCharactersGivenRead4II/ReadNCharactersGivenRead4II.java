/*
Read N Characters Given Read4 II

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) 
that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class ReadNCharactersGivenRead4II extends Reader4 {
   /**
    * @param buf Destination buffer
    * @param n   Maximum number of characters to read
    * @return    The number of characters read
    */
    private char [] buffer = new char[4];
    private int offset = 0, bufsize = 0; 

    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = (bufsize>0)? bufsize : read4(buffer);
            if (bufsie==0 && sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz); 
            // paramters: src, srcPos, dest, destPos, length
            System.arraycopy(buffer, offset, buf, readBytes, bytes);
            offset = (offset + bytes) % 4;
            bufsize = sz - bytes;
            readBytes += bytes;
        }
        return readBytes;
    }

    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        System.out.println((new ReadNCharactersGivenRead4II()).read(s,3));
    }
}

/*

*/
