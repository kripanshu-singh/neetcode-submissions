class Solution {
    public boolean check(int[] freq) {
        for(int i:freq){
            if(i!=0)return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int targetLength = s1.length();
        int[] freq = new int[26];
        for (int i = 0; i < targetLength; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            freq[s2.charAt(right) - 'a']--;
            if(right-left+1>targetLength){
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
            if(check(freq))return true;
            right++;
        }
        return false;
    }
}
