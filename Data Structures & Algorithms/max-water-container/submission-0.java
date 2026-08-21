class Solution {
    public int maxArea(int[] heights) {
        int l =0;
        int r = heights.length -1;
        int area = Integer.MIN_VALUE;

         while (l < r) {

            area = Math.max(
                (r - l) * Math.min(heights[l], heights[r]),
                area
            );

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}
