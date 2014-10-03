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


public class SimplifyPath {
   
    public String simplifyPath(String path) {
        java.util.Stack<String> pathsatck = new java.util.Stack<String>();
        pathsatck.push("/");
        String[] strarr = path.replace("/"," ").split(" ");
        for(String s:strarr){
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")){if(pathsatck.size()>1) pathsatck.pop();}
            else pathsatck.push(s+"/");
		}
        String simplepath = "";
        for(int i=0;i<pathsatck.size();i++)
			simplepath += pathsatck.get(i);
        if(pathsatck.size() > 1) simplepath = simplepath.substring(0,simplepath.length()-1);
        return simplepath;
    }

    public static void main(String args[]){
        String path1 = "/home/";
    	String path2 = "/a/./b/../../c/";
		String path3 = "/../";
    	String path4 = "/home//foo/";
        System.out.println((new SimplifyPath()).simplifyPath(path1));
		System.out.println((new SimplifyPath()).simplifyPath(path2));
		System.out.println((new SimplifyPath()).simplifyPath(path3));
		System.out.println((new SimplifyPath()).simplifyPath(path4));
    }
}
/*
Use a stack to store the path, if sub string element is:
(1) "/", skip it, look for next element;
(2) ".", doing nothing, look for next element;
(3) "..",pop the stack if not empty, look for next element;
(4) others, insert it to the stack, look for next element.
*/
