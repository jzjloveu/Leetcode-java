/*
Insert Interval 

Given a set of non-overlapping intervals, insert a new interval 
into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according 
to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as 
[1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
import java.util.*;

// Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.isEmpty()) { result.add(newInterval); return result; }
        intervals.add(newInterval);
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
        // int[][] invals = {{1,3},{6,9}}; int[] newIn = {2,5};
        int[][] invals = {{1,2},{3,5},{6,7},{8,10},{12,16}}; int[] newIn = {4,9};
        List<Interval> intervals = new ArrayList<Interval>();
        for(int[] i:invals) { intervals.add(new Interval(i[0],i[1])); }
        printList((new InsertIntervals()).insert(intervals,new Interval(newIn[0],newIn[1])));
    }
}

/*
This problem is similar as merge intervals.
1. Insert the new interval according to the start value.
2. Scan the whole intervals, merge two intervals if necessary.
*/