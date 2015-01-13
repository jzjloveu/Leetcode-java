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


public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<Integer,UndirectedGraphNode> visited = 
            new HashMap<Integer,UndirectedGraphNode>();
        return dfs(node, visited);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode v, 
            Map<Integer,UndirectedGraphNode> visited){
        UndirectedGraphNode res = new UndirectedGraphNode(v.label);
        visited.put(v.label, res);
        for(int i=0;i<v.neighbors.size();i++){
            if(!visited.containsKey(v.neighbors.get(i).label))
                res.neighbors.add(dfs(v.neighbors.get(i),visited));
            else
                res.neighbors.add(visited.get(v.neighbors.get(i).label));
        }
        return res;
    }
    public static void main(String args[]){
        UndirectedGraphNode n = new UndirectedGraphNode(0);
        UndirectedGraphNode c = (new CloneGraph()).cloneGraph(n);
        System.out.println(c.label); 
    }
}

/*
Using DFS.
So call clone means deep copy. For this problem, there are two major tasks:
(1)  Traverse the graph.
(2)  Construct the new graph at the same time. 
Same as clone a linked list.
*/