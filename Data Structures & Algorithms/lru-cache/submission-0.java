class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }
    // Declare references here
    private final Node dummyHead;
    private final Node dummyTail;
    private final HashMap<Integer, Node> map;
    private final int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        
        // Properly initialize inside the constructor
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            // deleteNode = delete(curr);
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
            // Insert to head;
            curr.next = dummyHead.next;
            curr.next.prev = curr;
            dummyHead.next = curr;
            curr.prev = dummyHead;
            return curr.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            // deleteNode = delete(curr);
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;

            // Insert to head;
            curr.next = dummyHead.next;
            curr.next.prev = curr;
            dummyHead.next = curr;
            curr.prev = dummyHead;
        } else {
            Node curr = new Node(key, value);
            map.put(key, curr);
            // Insert to head;
            curr.next = dummyHead.next;
            curr.next.prev = curr;
            dummyHead.next = curr;
            curr.prev = dummyHead;
            if (map.size()>size) {
                map.remove(dummyTail.prev.key);
                //  deleteLast(head);
                dummyTail.prev.prev.next = dummyTail;
                dummyTail.prev = dummyTail.prev.prev;

            }
        }
    }
}
