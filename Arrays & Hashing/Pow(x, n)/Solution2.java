class Solution2 {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }

        long exponent = n;
        if(exponent < 0){
            exponent = -exponent;
            x = 1/x;
        }
        return calculatePow(x, exponent);
    }

    private double calculatePow(double x, long exponent){
        if(exponent == 0){
            return 1;
        }
        else if(exponent == 1){
            return x;
        }

        double ans = calculatePow(x, exponent/2);
        if(exponent % 2 == 0){
            return ans * ans;
        }
        else {
            return ans * ans * x;
        }

    }
}