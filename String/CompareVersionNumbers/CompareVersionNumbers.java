/*
Compare Version Numbers 

Compare two version numbers version1 and version1.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and 
the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth 
second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/


public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1.isEmpty() || version2.isEmpty()) return 0;
        String[] stra=version1.split("\\."), strb=version2.split("\\.");
        for(int i=0;i<stra.length || i<strb.length;i++){
            int s1 = i<stra.length? Integer.parseInt(stra[i]):0;
            int s2 = i<strb.length? Integer.parseInt(strb[i]):0;
            if(s1 > s2) return 1;
            if(s1 < s2) return -1;
        }
        return 0;
    }

    public static void main(String args[]){
        String a = "1.11.1", b = "1.2.1";
        System.out.println((new CompareVersionNumbers()).compareVersion(a,b));
    }
}

