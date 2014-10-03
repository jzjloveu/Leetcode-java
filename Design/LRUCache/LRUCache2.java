/* 
LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/

//define the double linked list, each node stores both the key and value.
class Node {
	int key;
	int val;
	Node prev;
        Node next;
        Node(int key, int val) {
        	this.key = key;
        	this.val = val;
        	prev = null;
        	next = null;
        }
}

// implimentation using hashmap with double linked-list
public class LRUCache2 {
    private static Node head;
    private static Node tail;
    private static java.util.Map<Integer,Node> mapnode;
    private static int capacity;
    
    public LRUCache2(int capacity) {
    	    head = null;
    	    tail = null;
    	    mapnode = new java.util.HashMap<Integer,Node>();
    	    this.capacity = capacity;
    }
    
    //insert node to the tail of the linked list
    private static void insertNode(Node node){
    	    if(head == null){
    	    	    head = node;
    	    	    tail = node;
    	    }
    	    else{
    	    	    tail.next = node;
    	    	    node.prev = tail;
    	    	    tail = tail.next;
    	    }
    }
    
    //remove current node
    private static void removeNode(Node node){
    	    if(node == head){
    	    	    head = head.next;
    	    	    if(head != null)
    	    	    	    head.prev = null;
    	    }
    	    else{
    	    	    if(node == tail){
    	    	    	    tail = tail.prev;
    	    	    	    tail.next = null;
    	    	    }
    	    	    else{
    	    	    	    node.next.prev = node.prev;
    	    	    	    node.prev.next = node.next;
    	    	    }
    	    }
    }
    
    // move current node to the tail of the linked list
    private static void moveNode(Node node){
    	    if(node == tail)
    	    	    return;
    	    else{
    	    	    if(node == head){
    	    	            node.next.prev = null;
    	    	    	    head = node.next;
    	    	    	    tail.next = node;
    	    	    	    node.prev = tail;
    	    	    	    tail = tail.next;
    	    	            tail.next = null;
    	    	    }
    	    	    else{
    	    	    	    node.next.prev = node.prev;
    	    	    	    node.prev.next = node.next;
    	    	    	    tail.next = node;
    	    	    	    node.prev = tail;
    	    	    	    tail = tail.next;
    	    	            tail.next = null;
    	    	    }
    	    	    
    	    }
    }
    
    public int get(int key) {
        if(!mapnode.containsKey(key))
        	return -1;
        else{
        	moveNode(mapnode.get(key));
        	return mapnode.get(key).val;
        }
    }
    
    public void set(int key, int value) {
    	    if(mapnode.containsKey(key)){
    	    	    moveNode(mapnode.get(key));
    	    	    mapnode.get(key).val = value;
    	    }
    	    else{
    	    	    if(mapnode.size() == capacity){
    	    	    	    mapnode.remove(head.key);
    	    	    	    removeNode(head);
    	    	    }
    	    	    Node node = new Node(key,value);
    	    	    mapnode.put(key,node);
    	    	    insertNode(node);
    	    }
    }

	
    private void buildList(int[] arr){
    	for(int i:arr){
              Node node = new Node(i,i);
              mapnode.put(i,node);
              insertNode(node);
        }
    }
    
    private void printList(){
    	    Node curr = head;
    	    while(curr != null){
    	         System.out.format("<%d,%d> ",curr.key,curr.val);
    	         curr = curr.next;
    	    }
            System.out.println();  	 
    }
    
    public static void main(String args[]){
    	    int[] arr = {0,1,2,3,4,5,6,7,8,9};
    	    LRUCache2 sol = new LRUCache2(10);
    	    sol.buildList(arr);
    	    sol.printList();
    	    sol.get(5);
    	    sol.printList();
    	    sol.set(0,10);
    	    sol.set(10,10);
    	    sol.printList();
    }
}

