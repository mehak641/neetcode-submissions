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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Dummy node to simplify edge cases (like reversing from head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from left to right
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode sublistPrev = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = sublistPrev;
            sublistPrev = curr;
            curr = next;
        }

        // Step 3: Connect the reversed sublist back
        prev.next.next = curr;   // Connect tail of reversed sublist to remaining list
        prev.next = sublistPrev; // Connect node before sublist to new head of reversed part

        return dummy.next;
    }
}
