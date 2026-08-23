class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
       
        int l =0;

        while(l<prices.length){
            min = Math.min( min, prices[l]);
            maxProfit = Math.max(maxProfit  , prices[l]-min);
            l++;
            
        }
        
        return maxProfit;
    }
}
