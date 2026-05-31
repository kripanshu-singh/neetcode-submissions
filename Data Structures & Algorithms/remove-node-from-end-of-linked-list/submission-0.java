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
    public int findLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    public void solve(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 1; i <= n; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = findLength(head);
        if(n == len)return head.next;
        solve(head, len-n);
        return head;

    }
}
