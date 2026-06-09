class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = getVal(img, i, j);
                ans[i][j] = val;
            }
        }
        return ans;
    }

    private int getVal(int[][] img, int i, int j) {

        int n = img.length;
        int m = img[0].length;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        int sum = img[i][j];
        int count = 1;
        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];
            if (r < n && c < m && r >= 0 && c >= 0) {
                sum += img[r][c];
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;

    }
}