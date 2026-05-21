class Solution {
    public Boolean valid(int[] arr) {
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int matched = 0;
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        String ans = "";
        while (right < s.length()) {
            freq[s.charAt(right)]--;
            if (freq[s.charAt(right)] >= 0)
                matched++;
            while (matched >= t.length()) {
            if (ans.equals("") || ans.length() > (right - left + 1)) {
                ans = s.substring(left, right + 1);
            }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0)
                    matched--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
