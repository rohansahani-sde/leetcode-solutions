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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        List<ListNode> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            arr.add(curr);
            curr = curr.next;
        }
        arr.get(0).next = null;
        for(int i=1; i<arr.size(); i++){
            arr.get(i).next = arr.get(i-1);
        }
        return arr.get(arr.size()-1);
    }
}