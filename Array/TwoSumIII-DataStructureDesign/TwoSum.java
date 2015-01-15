/*
Two Sum III - Data structure design

Design and implement a TwoSum class. It should support the following operations:add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
import java.util.HashMap;

public class TwoSum {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public void add(int number){
        if(!map.containsKey(number)) map.put(number, 1);
        else map.put(number, map.get(number)+1);
    }

    public boolean find(int value){
        for(int key:map.keySet()){
            int val = value - key;
            if(val==key && map.get(key)>1) return true;
            if(val!=key && map.containsKey(val)) return true;
        }
        return false;
    }

    public static void main(String args[]){
        TwoSum sol = new TwoSum();
        sol.add(1); sol.add(3); sol.add(5);
        System.out.println(sol.find(4)+", "+sol.find(7));
    }
}
