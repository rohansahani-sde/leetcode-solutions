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
        int col;
        int row;
        Pair(TreeNode node, int col, int row){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, List<Integer>> > map = new TreeMap<>();
        
        bfs(root, map);

        for(TreeMap<Integer, List<Integer>> mp: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(List<Integer> l: mp.values()){
                Collections.sort(l);
                for(int x: l) temp.add(x);

            }
            ans.add(temp);
        }
        return ans;
    }
    private void bfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>> > map){
        if(root == null)return;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root, 0, 0));
        while(!que.isEmpty()){
            Pair curr = que.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);
             
               
            if(node.left != null) que.offer(new Pair(node.left, col-1, row+1));
            if(node.right != null) que.offer(new Pair(node.right, col+1, row+1));
            
        }
    }
}