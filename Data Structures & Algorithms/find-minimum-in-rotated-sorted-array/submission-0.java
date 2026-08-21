class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = (l + r) / 2;

            if (nums[mid] > nums[r]) {
                // Minimum right side mein hai
                l = mid + 1;
            } else {
                // Minimum left side ya mid par hai
                r = mid;
            }
        }

        return nums[l];
    }
}