class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // bucket[frequency] = numbers having that frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }

        int[] ans = new int[k];
        int idx = 0;

        // Highest frequency → lowest
        for (int count = nums.length; count >= 1 && idx < k; count--) {

            if (bucket[count] != null) {
                for (int num : bucket[count]) {
                    ans[idx++] = num;

                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}