class Solution {
    public void solve(int i, String s, List<String> temp, List<List<String>> ans) {
        if (i >= s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (checkPalindrome(i, j, s)) {
                temp.add(s.substring(i, j + 1));

                solve(j + 1, s, temp, ans);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkPalindrome(int s, int e, String str) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(0, s, temp, ans);
        return ans;
    }
}
