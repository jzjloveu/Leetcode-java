/*
Merge Intervals 

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
import java.util.*;

// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.isEmpty()) { return result; }
        // sort list in ascending order
        Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval a, Interval b){
                    return a.start-b.start;}});
        result.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i), 
                prev = result.get(result.size()-1);
            if(curr.start <= prev.end) 
                prev.end = Math.max(prev.end, curr.end);
            else 
                result.add(curr);
        }
        return result;
    }

    private static void printList(List<Interval> arr){
        System.out.print("[");
        for(int i=0;i<arr.size();i++){
            String str = "["+arr.get(i).start+","+arr.get(i).end+"]";
            if(i < arr.size()-1) str += ", ";
            System.out.print(str);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]){
        // int[][] invals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] invals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        List<Interval> intervals = new ArrayList<Interval>();
        for(int[] i:invals) { intervals.add(new Interval(i[0],i[1])); }
        printList((new MergeIntervals()).merge(intervals));
    }
}

/*
To check the intersections between interval [a,b] and [c,d],  
there are four cases (equal not shown in the figures):
    a____b
c____d
--------------
a____b
    c____d
--------------
a_______b
   c___d
--------------
   a___b
c_______d
--------------
So the idea is simple. 
First sort the list according to the start value. 
Second, scan every interval, if it can be merged to the previous one, 
then merge them, else push it into the result list.
*/