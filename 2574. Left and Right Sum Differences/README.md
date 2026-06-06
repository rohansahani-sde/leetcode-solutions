# 2574. Left and Right Sum Differences

### Difficulty: Easy

## Description
You are given a 0-indexed integer array nums of size n.

Define two arrays leftSum and rightSum where:


	leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
	rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.


Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

&nbsp;
Example 1:


Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].


Example 2:


Input: nums = [1]
Output: [0]
Explanation: The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].


&nbsp;
Constraints:


	1 &lt;= nums.length &lt;= 1000
	1 &lt;= nums[i] &lt;= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 2
- **Memory**: 46128000
- **Language**: java

## Code
```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        if(n == 1) return new int[]{0};
        
        int rightSum =0;
        for(int i=n-2; i>=0; i--){
            rightSum += nums[i+1];
        }
        int[] ans = new int[n];
        int leftSum =0;
        ans[0] = rightSum;
        for(int i=1; i<n-1; i++){
            leftSum += nums[i-1];
            rightSum -= nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
        }
        ans[n-1] = leftSum+nums[n-2];
        return ans;
    }
}
```
