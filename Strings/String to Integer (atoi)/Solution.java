class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;

        int i = 0;
        boolean negative = false;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            negative = s.charAt(i) == '-';
            i++;
        }

        long result = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            if (!negative && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (negative && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return negative ? (int) -result : (int) result;
    }
}
