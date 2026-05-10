
# 1248. Count Number of Nice Subarrays

### Medium

<p>Given an array of integers <code>nums</code> and an integer <code>k</code>. A continuous subarray is called <strong>nice</strong> if there are <code>k</code> odd numbers on it.</p>

<p>Return <em>the number of <strong>nice</strong> sub-arrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2,1,1], k = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,4,6], k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no odd numbers in the array.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,1,2,2,1,2,2,2], k = 2
<strong>Output:</strong> 16
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


---
## 🚀 Submission Details
- **Status**: Accepted
- **Runtime**: 13 ms
- **Memory**: 59.5 MB

## 💻 Code
```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k-1);
    } 
    private int fun(int[] nums, int k){
        int n = nums.length;
        int j=0;
        int ans=0;
        int count =0;
        for(int i=0; i<n; i++){
            if(nums[i] % 2 != 0)count++;
            while(count > k){
                if(nums[j] % 2 != 0)count--;
                j++;
            }
            ans += (i-j+1);
        }
        return ans;
    }
}
```
        