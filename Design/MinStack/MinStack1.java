/*
Min Stack

Design a stack that supports push, pop, top, and retrieving 
the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
import java.util.*;

public class MinStack1 {
    Stack<Long> diff;
    long min; // prevent overflow
    public MinStack1() {
        diff = new Stack<Long>();
        min = Integer.MAX_VALUE; 
    }
     
    public void push(int x) {
        diff.push((long)x-min);
        if(x < min) min = x;
    }
 
    public void pop() {
        if(!diff.isEmpty()) {
            Long d = diff.pop();
            min = d>=0 ? min : min-d;
        }
    }
 
    public int top() {
        if(diff.isEmpty()) return -1;
        Long d = diff.peek();
        return d>=0 ? (int)(d+min) : (int)min;
    }
 
    public int getMin() {
        return (int)min;
    }

    public static void main(String args[]){
        MinStack1 s = new MinStack1(); s.push(-1);
        System.out.println(s.top()+", "+s.getMin());
    }
}

/*
O(n) runtime, O(n) space - No Extra stack:
Use only one min varible and stack stroe the difference values.
For push process:
difference = value - min
update min when value < min
For pop process:
need update the min to LastMin 
astMin = min (when difference > 0)
LastMin = min - difference (when difference < 0)
For top process:
if difference > 0, then top value = difference + min
if difference < 0, then top value = min
*/