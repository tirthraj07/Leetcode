import java.util.Stack;

class Solution {
    class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int start = i;
            while (!st.isEmpty() && st.peek().second > heights[i]) {
                Pair top = st.pop();
                maxArea = Math.max(maxArea, top.second * (i - top.first));
                start = top.first;
            }
            st.push(new Pair(start, heights[i]));
        }

        while (!st.isEmpty()) {
            Pair top = st.pop();
            maxArea = Math.max(maxArea, top.second * (n - top.first));
        }

        return maxArea;
    }
}
