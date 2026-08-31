class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {

            // Add current character
            map.put(s.charAt(r),
                    map.getOrDefault(s.charAt(r), 0) + 1);

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            // Window is invalid
            while ((r - l + 1) - maxFreq > k) {

                map.put(s.charAt(l),
                        map.get(s.charAt(l)) - 1);

                l++;
            }

            // Valid window
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}