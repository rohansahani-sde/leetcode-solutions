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
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp  = head;
        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }
        int max = Integer.MIN_VALUE;
        int sum=0;
        int n = st.size();
        ListNode node = head;
        for(int  i=0; i<n/2; i++){
            sum = node.val + st.pop();
            max= Math.max(max, sum);
            node = node.next;
        }
        return max;
    }
}