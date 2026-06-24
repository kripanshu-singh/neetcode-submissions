class Solution {
    public void solve(int count, int n, StringBuilder temp, List<String> ans) {
        if(count<0)return;
        if(count == 0 && temp.length()==2*n){
            ans.add(temp.toString());
            return;
        }
        if(temp.length()==2*n){
            return;
        }

        temp.append("(");
        solve(count+1, n, temp, ans);
        temp.deleteCharAt(temp.length() - 1);

        temp.append(")");
        solve(count-1, n, temp, ans);
        temp.deleteCharAt(temp.length() - 1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        solve(0, n, temp, ans);
        return ans;
    }
}
