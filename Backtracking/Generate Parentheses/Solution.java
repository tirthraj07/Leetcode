import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> sol;
    StringBuilder parenthesis;

    private void dfs(int open, int close, int n) {
        if (open == n) {
            for (int i = close; i != n; i++) {
                parenthesis.append(")");
            }
            sol.add(parenthesis.toString());
            for (int i = close; i != n; i++) {
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            }
            return;
        }

        parenthesis.append("(");
        dfs(open + 1, close, n);
        parenthesis.deleteCharAt(parenthesis.length() - 1);

        if (open > close) {
            parenthesis.append(")");
            dfs(open, close + 1, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        sol = new ArrayList<>();
        if (n == 0)
            return sol;

        parenthesis = new StringBuilder();

        dfs(0, 0, n);

        return sol;
    }
}