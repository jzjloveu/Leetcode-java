/*
Gas Station 

There are N gas stations along a circular route, where the amount 
of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of 
gas to travel from station i to its next station (i+1). You begin 
the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around 
the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/
import java.util.*;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, k = -1;
        for(int i=0;i<gas.length;i++){
          sum += gas[i] - cost[i];
          total += gas[i] - cost[i];
          if(sum < 0){
            sum = 0;
            k = i;
          }
        }
        return (total >= 0)? k+1:-1; 
    }

    public static void main(String args[]){
        int[] gas = {3, 1, 2, 5, 4};
        int[] cost = {4, 1, 1, 2, 3};
        System.out.println((new GasStation()).canCompleteCircuit(gas,cost));
    }
}

/*
if sum(gas) < sum(cost) then answer is -1, otherwise it should have answer is 
start index. 
Idea of if have start index, sum = gas[i] - cost[i], when sum < 0, ignore it, 
since total must >=0 then rest of sum should >=0 
*/