/*
Copy List with Random Pointer 

A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list. 
*/
// Definition for singly-linked list with a random pointer.
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};
 
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){ return null;}
        RandomListNode newhead, curr, newNode;
        curr = head; // insert nodes
        while(curr != null){
        	newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }  
        curr = head; // copy random pointer  
        while(curr != null){ 
        	newNode = curr.next;
            if(curr.random != null) newNode.random = curr.random.next;
            curr = newNode.next;
        }
        curr = head; // saparate two lists
        newhead = head.next;
        while(curr != null){ 
        	newNode = curr.next;
            curr.next = newNode.next;
            if(newNode.next != null) newNode.next = newNode.next.next;
            curr = curr.next;
        }
        return newhead;
    }
      
    private static RandomListNode buildList(int[] arr){
        RandomListNode head = new RandomListNode(0);
        RandomListNode curr = head;
        for(int i:arr){
            curr.next = new RandomListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
    
    private static void printList(RandomListNode head){
        if (head==null){ System.out.print("null");}
    	while(head!=null){
            System.out.print(head.label+" ");
            head = head.next;	    
    	}  
        System.out.println();  	 
    }
    
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        CopyListWithRandomPointer sol = new CopyListWithRandomPointer();
        RandomListNode head = sol.buildList(arr);
        sol.printList(head);
        sol.printList(sol.copyRandomList(head));
    }
}

/*
Three steps:
1. Insert new Nodes in between the list. eg. N1->N2->N3...to N1->newN1->N2->newN2...
2. Copy the random pointer. 
3. Saparate the two lists.
*/