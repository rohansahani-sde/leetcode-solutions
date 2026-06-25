# 86. Partition List

### Difficulty: Medium

## Description
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 
Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]


Example 2:


Input: head = [2,1], x = 2
Output: [1,2]


 
Constraints:


	The number of nodes in the list is in the range [0, 200].
	-100 <= Node.val <= 100
	-200 <= x <= 200

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 44160000
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
```
