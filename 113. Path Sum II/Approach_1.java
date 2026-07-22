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
        fun(root, 0, new ArrayList<>(), targetSum);
        return ans;
    }
    private void fun(TreeNode root, int sum, List<Integer>  curr, int k){
        if(root == null) return;
        curr.add(root.val);
         sum += root.val;
         if(root.left == null && root.right ==null && sum ==k)ans.add(new ArrayList<>(curr));

         fun(root.left, sum, curr, k);
         fun(root.right, sum, curr, k);
        
        curr.remove(curr.size()-1);


        
    }
}