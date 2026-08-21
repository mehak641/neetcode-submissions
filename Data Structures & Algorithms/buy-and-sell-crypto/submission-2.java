class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int index =0;
        int max = 0;
        for( int i =0 ; i < prices.length;i++){
            min =prices[i];
        for( int k=i; k <prices.length ;k++ ){
            max = Math.max(prices[k]-min, max);
        }
        }
        return max;

    }
}
