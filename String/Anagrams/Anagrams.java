/*
Anagrams 

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/
import java.util.*;

public class Anagrams {
   
    public List<String> anagrams(String[] strs) {
        List<String> slist = new ArrayList<String>();
        if(strs==null || strs.length==0) return slist;
        Map<String,ArrayList<String>> sdict = new HashMap<String,ArrayList<String>>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if(sdict.containsKey(str)) sdict.get(str).add(s);
            else{  
                ArrayList<String> tmplist = new ArrayList<String>();
                tmplist.add(s);
                sdict.put(str,tmplist); 
            }  
        }    
        for(ArrayList<String> sl:sdict.values()){
            if(sl.size() > 1)
                for(String s:sl)
                    slist.add(s);
        } 
        return slist;
    }

    public static void main(String args[]){
        String[] strs = {"tac","cat","act","dog"};
        System.out.println((new Anagrams()).anagrams(strs));
    }
}

