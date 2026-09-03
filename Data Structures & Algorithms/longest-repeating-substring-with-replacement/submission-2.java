class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        int maxfreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxfreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
                         max = Math.max(max, r - l + 1);

            r++;
        }
        return max;
    }
}
