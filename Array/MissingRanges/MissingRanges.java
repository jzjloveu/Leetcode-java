/*
TMissing Ranges

Given a sorted integer array where the range of elements are [0, 99] inclusive, 
return its missing ranges.

For example, given [0, 1, 3, 50, 75], return ["2", "4->49", "51->74", "76->99"]
*/
import arrayUtil.*;
import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> ranges = new ArrayList<String>();
        int prev = lower - 1;
        for(int i=0;i<=A.length;i++){
            int curr = i==A.length? upper+1 : A[i];
            if(curr - prev > 1){
                String tmp=prev+1==curr-1?""+(prev+1):""+(prev+1)+"->"+(curr-1);
                ranges.add(tmp);
            }
            prev = curr;
        }
        return ranges;
    }

    public static void main(String args[]){
        int[] A = {0, 1, 3, 50, 75}; 
        int lower = 0, upper = 99;  
        ArrayListUtil.printList(
            (new MissingRanges()).findMissingRanges(A,lower,upper));
        
    }
}
