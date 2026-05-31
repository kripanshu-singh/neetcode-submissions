/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void solve(Node head, Node ans, HashMap<Node, Node> ogToNew) {
        Node curr = head;
        Node dummy = ans;

        while (curr != null) {
            Node temp = new Node(curr.val);
            ogToNew.put(curr, temp);
            dummy.next = temp;
            dummy = dummy.next;
            curr = curr.next;
        }
    }
    public void solveRandom(Node head, Node ans, HashMap<Node, Node> ogToNew) {
        Node curr = head;
        Node currAns = ans.next;
        while (curr != null) {
            if (curr.random == null) {
                currAns.random = null;
            } else {
                currAns.random = ogToNew.get(curr.random);
            }
            curr = curr.next;
            currAns = currAns.next;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> ogToNew = new HashMap<>();

        Node ans = new Node(-1);
        solve(head, ans, ogToNew);
        solveRandom(head, ans, ogToNew);
        return ans.next;
    }
}
