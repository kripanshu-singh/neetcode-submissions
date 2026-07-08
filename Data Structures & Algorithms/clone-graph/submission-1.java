/*
Definition for a Node.
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
*/

class Solution {
    public Node solve(Node node, Map<Node, Node> map) {
        if (node == null)
            return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }

        int curr = node.val;
        Node newNode = new Node(curr);

        map.put(node, newNode);
        List<Node> neigh = node.neighbors;
        List<Node> newNeigh = newNode.neighbors;
        for (int j = 0; j < neigh.size(); j++) {
            newNeigh.add(solve(neigh.get(j), map));
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return solve(node, map);
    }
}