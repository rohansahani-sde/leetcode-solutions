# 47. Permutations II

### Difficulty: Medium

## Description
Given a collection of numbers, nums,&nbsp;that might contain duplicates, return all possible unique permutations in any order.

&nbsp;
Example 1:


Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]


Example 2:


Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 8
	-10 &lt;= nums[i] &lt;= 10

## Submission Details
- **Status**: Accepted
- **Runtime**: 3
- **Memory**: 46424000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n= nums.length;
        boolean[] vis = new boolean[n];
        fun(nums, ans, new ArrayList<>(), vis);
        return ans;
    }
    private void fun(int[] arr, List<List<Integer>> ans, List<Integer> l, boolean[] vis){
        if(l.size()  == arr.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1] && !vis[i-1])continue;
            if(!vis[i]){
                l.add(arr[i]);
                vis[i] = true;
                fun(arr, ans, l, vis);
                l.remove(l.size()-1);
                vis[i] = false;
            }
        }
    }
}
```
