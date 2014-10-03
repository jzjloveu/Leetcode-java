/*
Longest Consecutive Sequence 

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
import java.util.*;

public class LongestConsecutive {
   
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:num){ set.add(i); }
        int maxlen = 0;
        for(int i:num){
            int count = 1, left = i-1, right = i+1;
            while (set.contains(left)) { count++;set.remove(left--); }
            while (set.contains(right)) { count++;set.remove(right++);}
            maxlen = Math.max(maxlen,count);
        }
        return maxlen;
    }
    public static void main(String args[]){
        int[] A = {100, 4, 200, 1, 3, 2};

        System.out.println((new LongestConsecutive()).longestConsecutive(A));
    }
}

/*
Note that it is not the classic DP problem, while this problem tests the data structure other than algorithm.

Since it requires O(n) solution, normal sort won't be work here. Hash probably is the best choice.
3 Steps:
1. create the hashmap to hold <num, index>
2. scan the num vector from left to right, for each num
               i, check whether num -1 is in the map  (loop)
              ii, check whether num+1 is in the map  (loop)
3. track the sequence length during scanning.

If using java map for this problem, will get TLE. 

After an element is checked, it should be removed from the set. Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
*/
