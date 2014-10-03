// Copy List with Random Pointer 

// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list. 

// Definition for singly-linked list with a random pointer.
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};
 
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
	if(head == null){ return null;}
        RandomListNode newhead, curr, newNode;
        // copy a[i] value to new b[i], and 
        // let a[i]->random store in b[i].next,
        // let b[i] store in a[i]->random
        curr = head;
        while(curr != null){
        	newNode = new RandomListNode(curr.label);
            	newNode.next = curr.random;
            	curr.random = newNode;
            	curr = curr.next;
        }   
        // let b[i]->random point to b[i]->next->random    
        curr = head;
        while(curr != null){ 
        	newNode = curr.random;
                newNode.random = (newNode.next!=null)?newNode.next.random:null;
                curr = curr.next;
        }
        newhead = head.random;
        // restore a[i].random and b[i].next
        curr = head;
        while(curr != null){ 
        	newNode = curr.random;
                curr.random = newNode.next;
                newNode.next = (curr.next!=null)?curr.next.random:null;
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
	CopyRandomList sol = new CopyRandomList();
        RandomListNode head = sol.buildList(arr);
        sol.printList(head);
        sol.printList(sol.copyRandomList(head));
    }
}
