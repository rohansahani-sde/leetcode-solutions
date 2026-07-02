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
    int size;
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = rev(head);
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[size];
        for(int i=size-1; i>=0; i--){
            while(!st.isEmpty() && curr.val >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = 0;
            else ans[i] = st.peek();
            st.push(curr.val);
            curr = curr.next;
        }
        return ans;
    }
    private ListNode rev(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size++;
        }
        return prev;
    }
}