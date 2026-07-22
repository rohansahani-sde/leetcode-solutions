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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        fun(root, new ArrayList<>(), targetSum);
        return ans;
    }
    private void fun(TreeNode root,  List<Integer>  curr, int k){
        if(root == null) return;
        curr.add(root.val);
         k -= root.val;
         if(root.left == null && root.right ==null && k==0)ans.add(new ArrayList<>(curr));

         fun(root.left,  curr, k);
         fun(root.right,  curr, k);
        
        curr.remove(curr.size()-1);


        
    }
}