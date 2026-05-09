class Solution {
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        if (strs.size() == 0)
            return "empty";
        for (String st : strs) {
            str.append(st);
            if (st.equals("")) {
                str.append("-1");
            }
            str.append("_@");
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if (str.equals("empty"))
            return ans;
        String[] arr = str.split("_@");

        for (String i : arr) {
            if (i.equals("-1"))
                ans.add("");
            else
                ans.add(i);
        }

        // if (ans.size() <= 0)
        //     ans.add("");

        return ans;
    }
}
