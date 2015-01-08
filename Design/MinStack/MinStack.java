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

public class MinStack {
    private Stack<Integer> st, minst;
    public MinStack(){
        st =  new Stack<Integer>();
        minst = new Stack<Integer>();
    }

    public void push(int x) {
        if(st.isEmpty() || x <= getMin())
            minst.push(x);
        st.push(x);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if(st.peek() == getMin())
                minst.pop();
            st.pop();
        }
    }

    public int top() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }

    public int getMin() {
        if(minst.isEmpty()) return Integer.MAX_VALUE;
        return minst.peek();
    }

    public static void main(String args[]){
        MinStack s = new MinStack(); s.push(-1);
        System.out.println(s.top()+", "+s.getMin());
    }
}

/*
O(n) runtime, O(n) space - Extra stack:
If a new element is larger than the current minimum, we do not need to push 
it on to the min stack. When we perform the pop operation, check if the popped 
element is the same as the current minimum. If it is, pop it off the min stack too.
*/