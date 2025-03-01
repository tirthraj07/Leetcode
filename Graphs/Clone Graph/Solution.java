import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

// 2 pass solution
class Solution {
    private HashMap<Node, Node> map;
    private HashSet<Node> set;

    private void pass1(Node node) {
        if (map.containsKey(node))
            return;
        map.put(node, new Node(node.val));
        for (Node neighbour : node.neighbors) {
            pass1(neighbour);
        }
    }

    private void pass2(Node node) {
        if (set.contains(map.get(node)))
            return;

        Node copyNode = map.get(node);
        for (Node neighbour : node.neighbors) {
            copyNode.neighbors.add(map.get(neighbour));
        }

        set.add(copyNode);
        for (Node neighbour : node.neighbors) {
            pass2(neighbour);
        }

    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        map = new HashMap<>();
        set = new HashSet<>();
        pass1(node);

        pass2(node);

        return map.get(node);
    }
}

// 1 Pass solution
class Solution2 {

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node oldNode, Map<Node, Node> oldToNew) {
        if (oldNode == null)
            return null;

        if (oldToNew.containsKey(oldNode)) {
            return oldToNew.get(oldNode);
        }

        Node copyNode = new Node(oldNode.val);

        oldToNew.put(oldNode, copyNode);

        for (Node neightbour : oldNode.neighbors) {
            copyNode.neighbors.add(dfs(neightbour, oldToNew));
        }

        return copyNode;
    }

}