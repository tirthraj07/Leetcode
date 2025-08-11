
// Definition for a Node.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Map<Integer, Node> valToNode = new HashMap<>();
        Node copyRoot = dfs(node, valToNode);
        return copyRoot;
    }
    

    public Node dfs(Node root, Map<Integer, Node> valToNode){
        if(valToNode.containsKey(root.val)){
            return valToNode.get(root.val);
        }

        valToNode.put(root.val, new Node(root.val));
        Node copyNode = valToNode.get(root.val);
        copyNode.neighbors = new ArrayList<>();

        for(Node neighbor: root.neighbors){
            copyNode.neighbors.add(dfs(neighbor, valToNode));
        }

        return copyNode;
    }



}