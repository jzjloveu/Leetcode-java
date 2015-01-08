/*
Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class CountAndSay {
   
    public String countAndSay(int n) {
        String result = "1";
        for(int i=0;i<n-1;i++){
            char prev = '\0';
            String news = "";
            int num = 0;
            for(int j=0;j<result.length();j++){
                char curr = result.charAt(j);
                if(prev !='\0' && prev != curr){
                    news += "" + num + prev;
                    num = 1;
                }
                else{ num++;}
                prev = curr;
            }
            news += "" + num + prev;
            result = news;
        }
        return result;
    }

    public static void main(String args[]){
        int[] num = {1,2,3,4,5,6};
        CountAndSay sol = new CountAndSay();
        for(int n:num)
            System.out.println(sol.countAndSay(n));
    }
}

/*
The better problem declare:
when n=1 output string '1'(base case); when n=2, count the number of previous 
digit, since last string is '1', so output is '11; when n=3, previous string 
is '11', since there is two '1', so output is '21'; and when n=4, so there is 
one '2' and one '1', so output is '1211'.
*/

