class Solution {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }

        /*
            In java, if n = -2147483648 == Integer.MIN_VALUE, then abs(n) is STILL -2147483648 
            This is due to the fact that integer range is from -2,147,483,648 to 2,147,483,647
            on -2147483648, it cannot return the positive counterpart 2147483648, because that number is outside the range of a 32-bit signed integer.
            We'll have to handle the case explicitly
        */

        int absExponent = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(n);
        double xRaisedToN = calculatePow(x, absExponent);
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                xRaisedToN *= x;
            }
            return 1/xRaisedToN;
        }
        return xRaisedToN;
    }

    private double calculatePow(double x, int n){
        if(n == 0){
            return 1;
        }
        else if(n == 1){
            return x;
        }

        double ans = calculatePow(x, n/2);
        if(n % 2 == 1){
            return ans * ans * x;
        }
        else {
            return ans * ans;
        }

    }
}