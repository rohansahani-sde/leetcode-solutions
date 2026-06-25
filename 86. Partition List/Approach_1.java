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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode temp = head;
        while(temp != null){
            int val = temp.val;
            if(val < x){
                l1.next = new ListNode(val);
                l1 = l1.next;
            }
            else{
                l2.next = new ListNode(val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        l1.next = l2Head.next;
        return l1Head.next;
    }
}