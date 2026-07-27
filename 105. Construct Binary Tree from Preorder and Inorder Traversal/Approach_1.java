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
     int i=0;
    public TreeNode buildTree(int[] pre, int[] ino) {
        map = new HashMap<>();
        int n = pre.length;
        for(int i=0; i<n; i++){
            map.put(ino[i], i);
        }

        return fun(pre, ino, 0, n-1);
    }
    private TreeNode fun(int[] pre, int[] ino, int s, int e){
        if(s > e) return null;
        int idx = map.get(pre[i]);
        TreeNode node = new TreeNode(pre[i++]);
        node.left = fun(pre, ino, s, idx-1);
        node.right = fun(pre, ino, idx+1, e);

        return node;

    }
}