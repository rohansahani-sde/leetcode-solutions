/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans =0;
        while(!q.isEmpty()){
            
            int size = q.size();
            int first = q.peek().idx;
            int last = first;
            while(size-- >0){
                Pair curr = q.poll();
                int idx = curr.idx;
                last = idx;
                if(curr.node.left != null) q.offer(new Pair(curr.node.left, (idx*2)+1 ));
                if(curr.node.right != null) q.offer(new Pair(curr.node.right, (idx*2)+2 ));
            }
            ans = Math.max(ans, (last - first+1));
            
        }
        return ans;
    }
}