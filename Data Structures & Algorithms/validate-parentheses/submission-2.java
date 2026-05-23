class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        if (s.length() % 2 != 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stk.push(curr);
            } else {
                if (!stk.isEmpty()
                    && ((curr == ')' && stk.peek() == '(') || (curr == ']' && stk.peek() == '[')
                        || (curr == '}' && stk.peek() == '{'))) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stk.isEmpty())
            return false;
        return true;
    }
}
