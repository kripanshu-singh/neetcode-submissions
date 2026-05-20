class Solution {
    public int findFreq(int[] freq) {
        int num = 0;
        for (int i : freq) {
            num = Math.max(num, i);
        }
        return num;
    }
    public int characterReplacement(String s, int k) {
        int[] freq = new int[27];
        // AAABABB
        int left = 0;
        int right = 0;
        int n = s.length();
        int ans = 0;
        while (right < n) {
            char curr = s.charAt(right);
            freq[curr - 'A']++;
            // find most freq
            int mostFreq = findFreq(freq);
            int winSize = right - left + 1;
            while (left < n && k < winSize - mostFreq) {
                freq[s.charAt(left) - 'A']--;
                mostFreq = findFreq(freq);
                left++;
                winSize = right - left + 1;
            }
            ans = Math.max(ans, winSize);
            right++;
        }
        return ans;
    }
}
