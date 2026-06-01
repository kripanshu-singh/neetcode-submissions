/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode curr : lists) {
            minHeap.add(curr);
        }
        ListNode ans = new ListNode(-1);
        ListNode pntr = ans;
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.poll();
            if (curr.next != null)
                minHeap.add(curr.next);

            pntr.next = curr;
            pntr = pntr.next;
        }
        return ans.next;
    }
}
