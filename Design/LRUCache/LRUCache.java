/* 
LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 
*/
public class LRUCache {
    private java.util.Map<Integer,Integer> cache;
    private int capacity;
    
    public LRUCache(int capacity) {
        cache = new java.util.LinkedHashMap<Integer,Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = cache.get(key);
        if(value == null)
        	return -1;
        else{
        	cache.remove(key);
        	cache.put(key,value);
        	return value;
        }
    }
    
    public void set(int key, int value) {
    	    if(cache.get(key) != null){
    	    	    cache.remove(key);
    	    	    cache.put(key,value);
    	    }
    	    else{
    	    	    if(cache.size() == capacity){
    	    	    	    java.util.Iterator<java.util.Map.Entry<Integer,Integer>> iter = 
    	    	    	    		cache.entrySet().iterator();
    	    	    	    iter.next();
    	    	    	    iter.remove();
    	    	    }
    	    	    cache.put(key,value);
    	    }
    }

	
    private void buildList(int[] arr){
    	LRUCache lrucache = new LRUCache(capacity);
	for(int i:arr)
             lrucache.set(i,i);
        
        this.cache = lrucache.cache;
    }
    
    private void printList(){
    	    Object[] keys = cache.keySet().toArray();
    	    for(Object key:keys)
    	         System.out.format("<%d,%d> ",(int)key,cache.get(key));
            System.out.println();  	 
    }
    
    public static void main(String args[]){
    	    int[] arr = {0,1,2,3,4,5,6,7,8,9};
    	    LRUCache sol = new LRUCache(10);
    	    sol.buildList(arr);
    	    sol.printList();
    	    sol.get(5);
    	    sol.printList();
    	    sol.set(1,10);
    	    sol.set(10,10);
    	    sol.printList();
    }
}

/*
Class LinkedHashMap<K,V>

Hash table and linked list implementation of the Map interface, with predictable 
iteration order. This implementation differs from HashMap in that it maintains 
a doubly-linked list running through all of its entries. This linked list defines 
the iteration ordering, which is normally the order in which keys were inserted 
into the map (insertion-order). 
*/
