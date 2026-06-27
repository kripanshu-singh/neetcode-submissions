class Solution {
    String[] numPad = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void solve(int i, String digits, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        int digit = digits.charAt(i) - '0';
        String curr = numPad[digit];
        for (int j = 0; j < curr.length(); j++) {
            sb.append(curr.charAt(j));
            solve(i + 1, digits, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();

        solve(0, digits, sb, ans);
        return ans;
    }
}