class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<Integer>();
        for( int i=0; i < nums.length;i++){
            set.add(nums[i]);
        }
       
        for (int num : nums) {

    if (!set.contains(num - 1)) {

        int current = num;
        int currentCount = 1;

        while (set.contains(current + 1)) {
            current++;
            currentCount++;
        }

        longest = Math.max(longest, currentCount);
    }
}
        return longest;
    }
}
