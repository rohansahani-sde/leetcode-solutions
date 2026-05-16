
# 875. Koko Eating Bananas

### Medium

<p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---
## 🚀 Submission Details
- **Status**: Accepted
- **Runtime**: 6 ms
- **Memory**: 47.7 MB

## 💻 Code
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return fun(piles, h);
    }
    private int fun(int[] arr, int h){
        int hi = -1;
        int lo = 1;
        for(int x: arr) hi = Math.max(hi, x);
        int ans = -1;
        
        while( lo <= hi){
            int mid = lo +(hi -lo)/2;
            if(canEat(arr, mid, h)){
                ans = mid;
                hi = mid-1;
            }else lo =mid+1;
        }
        return ans;
    }
    private boolean canEat(int[] arr, int mid, int h){
        long time = 0;
        for(int x: arr){
            time += (x + mid -1)/mid;
        }
        return time <= h;
    }
}
```
        