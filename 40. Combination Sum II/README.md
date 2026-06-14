# 40. Combination Sum II

### Difficulty: Medium

## Description
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates&nbsp;where the candidate numbers sum to target.

Each number in candidates&nbsp;may only be used once in the combination.

Note:&nbsp;The solution set must not contain duplicate combinations.

&nbsp;
Example 1:


Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]


Example 2:


Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]


&nbsp;
Constraints:


	1 &lt;=&nbsp;candidates.length &lt;= 100
	1 &lt;=&nbsp;candidates[i] &lt;= 50
	1 &lt;= target &lt;= 30

## Submission Details
- **Status**: Accepted
- **Runtime**: 8
- **Memory**: 46632000
- **Language**: java

## Code
```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(cand);
        fun(cand, 0, target, ans, new ArrayList<>());
        return ans;
    }
    private void fun(int[] arr, int idx, int k, List<List<Integer>> ans, List<Integer> curr){
        if(k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == arr.length || k<0){
            return;
        }
       
        curr.add(arr[idx]);
        fun(arr, idx+1, k-arr[idx], ans, curr);
        curr.remove(curr.size()-1);
        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
            idx++;
        }

        fun(arr, idx+1, k, ans, curr);

    }
}
```
