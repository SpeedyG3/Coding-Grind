/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// LC DAILY MAY
// 237. Delete Node in a Linked List - medium
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;
        while(node.next!=null){
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }        
        prev.next = null;
    }
}