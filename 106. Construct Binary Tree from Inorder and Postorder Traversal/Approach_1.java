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
    Map<Integer, Integer> map;
    int i;
    public TreeNode buildTree(int[] ino, int[] pos) {
        map = new HashMap<>();
        int n = ino.length;
        for(int i=0; i<n; i++)map.put(ino[i], i);
        i = n- 1;
        return fun(ino, pos, 0, n-1);
    }
    private TreeNode fun(int[] ino, int[] pos, int s, int e){
        if(s > e ) return null;
        TreeNode node = new TreeNode(pos[i]);
        int idx = map.get(pos[i--]);

        node.right = fun(ino, pos, idx+1, e);
        node.left= fun(ino, pos, s, idx-1);
        return node;
    }
}