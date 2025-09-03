// Bottom up: Space Optimized

class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }

        int ptr1 = 0;
        int ptr2 = 1;
        int ptr3 = 1;
        for(int i=2; i<=n; i++){
            ptr3 = ptr1 + ptr2;
            ptr1 = ptr2;
            ptr2 = ptr3;
        }

        return ptr3;
    }
}