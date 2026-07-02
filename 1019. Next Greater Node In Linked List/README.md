# 1019. Next Greater Node In Linked List

### Difficulty: Medium

## Description
You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

 
Example 1:


Input: head = [2,1,5]
Output: [5,5,0]


Example 2:


Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]


 
Constraints:


	The number of nodes in the list is n.
	1 <= n <= 104
	1 <= Node.val <= 109

## Submission Details
- **Status**: Accepted
- **Runtime**: 24
- **Memory**: 49468000
- **Language**: java

## Code
```java
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
```
