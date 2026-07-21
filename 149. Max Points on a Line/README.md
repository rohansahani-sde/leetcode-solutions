# 149. Max Points on a Line

### Difficulty: Hard

## Description
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 
Example 1:


Input: points = [[1,1],[2,2],[3,3]]
Output: 3


Example 2:


Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4


 
Constraints:


	1 <= points.length <= 300
	points[i].length == 2
	-104 <= xi, yi <= 104
	All the points are unique.

## Submission Details
- **Status**: Accepted
- **Runtime**: 29
- **Memory**: 46664000
- **Language**: java

## Code
```java
class Solution {
    public int maxPoints(int[][] arr) {
        int max = 1;
        int n = arr.length;
        if(n == 1)  return 1;
        for(int i=0; i<n; i++){
            Map<Double, Integer>  map = new HashMap<>();
            for(int j=0; j <n; j++){
                if(i == j) continue;
                double slop;
                if(arr[j][0] - arr[i][0] != 0) {
                    slop = (arr[j][1] - arr[i][1] ) * 1.0 / (arr[j][0] - arr[i][0]);
                }
                else slop = Integer.MAX_VALUE;
                map.put(slop, map.getOrDefault(slop, 0)+1);
                max = Math.max(max, map.get(slop));

            }

        }
        return max+1;
    }
}
```
