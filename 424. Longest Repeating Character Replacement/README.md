
# 424. Longest Repeating Character Replacement

### Medium

<p>You are given a string <code>s</code> and an integer <code>k</code>. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most <code>k</code> times.</p>

<p>Return <em>the length of the longest substring containing the same letter you can get after performing the above operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ABAB&quot;, k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the two &#39;A&#39;s with two &#39;B&#39;s or vice versa.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;AABABBA&quot;, k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the one &#39;A&#39; in the middle with &#39;B&#39; and form &quot;AABBBBA&quot;.
The substring &quot;BBBB&quot; has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only uppercase English letters.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>


---
## 🚀 Submission Details
- **Status**: Accepted
- **Runtime**: 8 ms
- **Memory**: 46.2 MB

## 💻 Code
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int j=0;
        int maxLen=0;
        int max = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch-'A']++;
            max =Math.max(max, arr[ch - 'A'] );
            int diff = (i-j+1) -  max;
            if(diff <= k){
                maxLen = Math.max(maxLen, i-j+1); 
            }else{
                char left = s.charAt(j);
                arr[left-'A']--;
                j++;
            }
        }
        return maxLen;

    }
}
```
        