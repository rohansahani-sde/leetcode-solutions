class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        fun(image, sr, sc, original, color);
        return image;
    }
    private void fun(int[][] arr, int sr, int sc, int original, int color){
        if(sr >= arr.length || sr < 0 || sc >= arr[0].length || sc<0 || color == arr[sr][sc]){
            return;
        }
        if(arr[sr][sc] == original){
        arr[sr][sc] = color;
        fun(arr, sr, sc+1, original, color);
        fun(arr, sr, sc-1, original, color);
        fun(arr, sr+1, sc, original, color);
        fun(arr, sr-1, sc, original, color);
        }
    }
}