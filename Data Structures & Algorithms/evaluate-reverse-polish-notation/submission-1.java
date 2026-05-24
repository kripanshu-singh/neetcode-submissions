class Solution {
    public int evalRPN(String[] tokens) {
        //    int ans = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
                int b = stk.pop();
                int a = stk.pop();
                int ans = 0;
                if (curr.equals("+"))
                    ans = a + b;
                else if (curr.equals("-"))
                    ans = a - b;
                else if (curr.equals("*"))
                    ans = a * b;
                else if (curr.equals("/"))
                    ans = a / b;

                stk.push(ans);
            } else
                stk.push(Integer.parseInt(curr));
        }
        return stk.peek();
    }
}