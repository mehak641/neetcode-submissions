class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int [] ans = new int [n];
        int l =0;
        while( l < arr.length){
            ans[l] = findMax(arr , l);
            l++;
        }
        return ans;


    }
    private int findMax( int [] arr , int l){
        int max = -1;
        for( int i =l+1; i < arr.length;i++){
            max = Math.max(arr[i], max);
        }
        return max;
    }
}