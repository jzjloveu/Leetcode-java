/*
Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
import java.util.Stack;

public class SimplifyPath1 {
   
    public String simplifyPath(String path) {
        Stack<String> pathsatck = new Stack<String>();
        int i = 0;
        while(i < path.length()){
			while(i<path.length() && path.charAt(i)=='/') i++; //skip the begining '/'
            if(i == path.length()) break;
            int start = i;
            while(i<path.length() && path.charAt(i)!='/') i++; //set the end boundary
            int end = i;
            String element = path.substring(start,end);
            if(element.equals("..")){
				if(!pathsatck.empty())
					pathsatck.pop();
            }
			else if(!element.equals("."))
					pathsatck.push(element);
		}
		if(pathsatck.size() == 0) return "/";
        String simplePath = "";
        for(i=0;i<pathsatck.size();i++) simplePath += "/"+pathsatck.get(i);
        return simplePath;
    }

    public static void main(String args[]){
        String path1 = "/home/";
    	String path2 = "/a/./b/../../c/";
		String path3 = "/../";
    	String path4 = "/home//foo/";
        System.out.println((new SimplifyPath1()).simplifyPath(path1));
		System.out.println((new SimplifyPath1()).simplifyPath(path2));
		System.out.println((new SimplifyPath1()).simplifyPath(path3));
		System.out.println((new SimplifyPath1()).simplifyPath(path4));
    }
}
/*
Use a stack to store the path, if sub string element is:
(1) "/", skip it, look for next element;
(2) ".", doing nothing, look for next element;
(3) "..",pop the stack if not empty, look for next element;
(4) others, insert it to the stack, look for next element.
*/
