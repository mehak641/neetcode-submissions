class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>(); // indices store karenge

        for (int i = 0; i < n; i++) {
            // jab tak current temp > stack ke top ka temp
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex; // kitne din baad bada temp mila
            }
            stack.push(i);
        }
        return ans;
    }
}
