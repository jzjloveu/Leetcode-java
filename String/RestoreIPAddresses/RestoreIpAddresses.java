/*
Restore IP Addresses

Given a string containing only digits, restore it by returning all possible 
valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s)  {
        List<String> res = new ArrayList<String>();
        if(s.replaceFirst("^0+(?!$)", "").length()>12)
	       return res;
        else
	       return getIP(s,"",0,res);
    }

    private static List<String> getIP(String s, String currIP, int currIndex, List<String> res){
        if(currIndex == 3)
            if(s.length() > 0)
                if(s.replaceFirst("^0+(?!$)", "").equals(s) && Long.parseLong(s)<=255)
                    res.add(currIP+s);

        for(int i=1;i<4;i++)
       	   if(s.length()>=i && s.substring(0,i).replaceFirst("^0+(?!$)", "").equals(s.substring(0,i)) 
                && Long.parseLong(s.substring(0,i))<=255)
	           getIP(s.substring(i),currIP+s.substring(0,i)+".",currIndex+1,res);
        return res;
    }

    public static void main(String args[]){
        String s = "25525511135";//"459022042";//"0279245587303";
        System.out.println((new RestoreIpAddresses()).restoreIpAddresses(s));
    }
}
/*
Using DFS. s.replaceFirst("^0+(?!$)", "") just for remove the leading 0, 
because  "0X" or "00X" is not valid.
*/
