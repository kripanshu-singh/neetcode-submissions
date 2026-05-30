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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        if(list2.val<list1.val){
return mergeTwoLists(list2,list1);
        }
        // ListNode dummy = list1;
        ListNode ans = list1;
        ListNode prev1 = list1;
        while (list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            if (list1.val <= list2.val) {
                prev1 = list1;
                list1 = list1.next;
            } else {
                ListNode temp2 = list2.next;
                prev1.next = list2;
                list2.next = list1;
                prev1 = list2;
                list2 = temp2;
            }
        }
        if (list2 != null) {
            prev1.next = list2;
        }
        return ans;
    }
}