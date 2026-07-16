class Solution {
    public int longestOnes(int[] arr, int k) {
        int ans = 0;
        int n = arr.length;
        int zero = 0;
        int j=0;
        for(int i=0; i<n; i++){

            
                if(arr[i] == 0) zero++;
                if(zero <= k){
                    ans = Math.max(ans, i-j+1);
                }
                else{
                    if(arr[j] == 0) zero--;
                    j++; 
                }
                

                
            

        }
        return ans;
        
    }
}