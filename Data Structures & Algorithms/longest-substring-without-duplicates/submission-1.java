class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        if(n == 0)return 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right<n){
            char curr = s.charAt(right);

            while(left<n && set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            ans = Math.max(ans, right-left);
            right++;
        }
        return ans+1;
    }
}
