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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return bfs(root);
    }
    private int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int c =1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                c++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
            else{
                if(node.left == null && node.right == null) return c;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return c;
    }
}