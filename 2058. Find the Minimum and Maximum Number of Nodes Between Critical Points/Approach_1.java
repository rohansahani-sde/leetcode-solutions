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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next == null || head.next.next==null) return new int[]{-1, -1};
        int pre = head.val;
        ListNode node = head.next;
        int i=1;

        int idx1 = -1;
        int ore =0;
        int min = Integer.MAX_VALUE;
        int max =0;
        int preidx=0;
        
        while(node.next != null){
            int curr = node.val;
            int next = node.next.val;
            if((curr > pre && curr > next) || (curr <  pre && curr < next)){
                if(idx1 ==-1){
                    idx1 = i;
                }
                else{
                    min = Math.min(min, i - preidx);
                    max = i -  idx1;
                }
                preidx = i;
            }

            pre = curr;
            i++;
            node = node.next;
        }
        if(idx1 ==-1 || idx1 == preidx) return new int[]{-1,-1};
        



    return new int[]{min, max};
    }
}