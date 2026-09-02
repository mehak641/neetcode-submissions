class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;

        while (r < s2.length()) {

            // Add right character
            count2[s2.charAt(r) - 'a']++;

            // Window size > s1.length()
            if (r - l + 1 > s1.length()) {
                count2[s2.charAt(l) - 'a']--;
                l++;
            }

            // Same frequencies = permutation
            if (Arrays.equals(count1, count2)) {
                return true;
            }

            r++;
        }

        return false;
    }
}