/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        ListNode h1 = headA, h2 = headB;
        int diff = Math.abs(len1 - len2);
        if(len1 >= len2){
            while(diff-- >0) h1 = h1.next;
        }else{
            while(diff-- >0) h2 = h2.next;
        }
        while(h1 != null && h2 != null){
            if(h1 == h2){
                return h1;
            } 
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
    private int getLen(ListNode node){
        ListNode temp = node;
        int s=0;
        while(temp != null){
            temp = temp.next;
            s++;
        }
        return s;
    }
}