class Solution {
    public String encode(List<String> strs) {
        int n = strs.size();
        if (n == 0) {
            return "empty";
        }

        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            if (s.equals("")) {
                str.append(-1);
            }
            str.append(s);
            str.append("@_");
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        if (str.equals("empty")) {
            return ans;
        }
        System.out.println(str);
        String[] arr = str.split("@_");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("-1"))
                ans.add("");
            else
                ans.add(arr[i]);
        }

        return ans;
    }
}
