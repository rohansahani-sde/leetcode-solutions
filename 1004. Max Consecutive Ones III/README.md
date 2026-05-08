
# 1004. Max Consecutive Ones III

### Medium

<p>Given a binary array <code>nums</code> and an integer <code>k</code>, return <em>the maximum number of consecutive </em><code>1</code><em>&#39;s in the array if you can flip at most</em> <code>k</code> <code>0</code>&#39;s.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> [1,1,1,0,0,<u><strong>1</strong>,1,1,1,1,<strong>1</strong></u>]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
<strong>Output:</strong> 10
<strong>Explanation:</strong> [0,0,<u>1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1</u>,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>0 &lt;= k &lt;= nums.length</code></li>
</ul>


---
## 🚀 Submission Details
- **Status**: Accepted
- **Runtime**: 4 ms
- **Memory**: 51.8 MB

## 💻 Code
```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int oneCount =0;
        for(int x: nums)if(x == 1)oneCount++;
        if(oneCount == 0) return k < n ? k :n ;
        int max = 0;
        int one =0;
        int zero =0;
        int j=0;
        for(int i=0; i<n; i++){
            if(nums[i] ==0) zero++;
            if(nums[i] == 1) one++;

            if(zero <= k){
                max = Math.max(max, one+zero);
            }
            else{
                while(zero > k && j<i){
                    if(nums[j] ==0)zero--;
                    if(nums[j] ==1)one--;
                    j++;
                }
                max = Math.max(max, one+zero);
            }
        }
        
        return max;
    }
}
```
        