class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    void dfs(int[] nums, int target, int i,
             List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            dfs(nums, target - nums[j], j, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}