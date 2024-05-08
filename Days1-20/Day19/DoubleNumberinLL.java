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
// 2816. Double a Number Represented as a Linked List - medium
class Solution {
    public static ListNode rev(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nex = null;
        while(curr!=null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode revList = rev(head);
        int c = 0;
        ListNode temp = revList;
        ListNode newHead = null;
        while(temp!=null){
            int val = temp.val*2 + c;
            int s = val%10;
            c = val/10;
            ListNode newNode = new ListNode(s, newHead);
            newHead = newNode;
            temp = temp.next;
        }
        if(c!=0){
            ListNode newNode = new ListNode(c, newHead);
            newHead = newNode;
        }
        return newHead;
    }
}