/*
Clone Graph 

Clone an undirected graph. Each node in the graph contains a label 
and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node 
label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three 
parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus 
forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
import java.util.*;


// Definition for undirected graph. 
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { 
        label = x; 
        neighbors = new ArrayList<UndirectedGraphNode>(); 
    }
};


public class CloneGraph1 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer,UndirectedGraphNode> newNodes = 
            new HashMap<Integer,UndirectedGraphNode>();
        newNodes.put(node.label,new UndirectedGraphNode(node.label));
        Set<UndirectedGraphNode> visited =
            new HashSet<UndirectedGraphNode>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
        Deque<UndirectedGraphNode> newqueue = new ArrayDeque<UndirectedGraphNode>();
        queue.add(node); newqueue.add(newNodes.get(node.label));
        visited.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode newcurNode = newqueue.poll();
            Iterator<UndirectedGraphNode> iter = curNode.neighbors.iterator();
            while(iter.hasNext()){
                UndirectedGraphNode n = iter.next();
                if(!newNodes.containsKey(n.label))
                    newNodes.put(n.label,new UndirectedGraphNode(n.label));
                newcurNode.neighbors.add(newNodes.get(n.label));
                if(!visited.contains(n)){
                    queue.add(n); newqueue.add(newNodes.get(n.label));
                    visited.add(n);
                }
            }
        }
        return newNodes.get(node.label);
    }

    public static void main(String args[]){
        UndirectedGraphNode n = new UndirectedGraphNode(0);
        UndirectedGraphNode c = (new CloneGraph1()).cloneGraph(n);
        System.out.println(c.label); 
    }
}

/*
Using BFS.
So call clone means deep copy. For this problem, there are two major tasks:
(1)  Traverse the graph
(2)  Construct the new graph at the same time.
Traverse the graph is similar to the tree traversal, both DFS and  BFS can be used. 
Slight difference  is to consider the loop in the graph (e.g., the 2-->2 in the above figure), 
thus we need store the visited vertex information. If the neighbor of current node 
has not been visited, then search that node.s
*/