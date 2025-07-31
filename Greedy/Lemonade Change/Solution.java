class Solution {
    public boolean lemonadeChange(int[] bills) {
                             //5,10,20
        int[] change = new int[]{0,0,0};

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                change[0] += 1;
            } else if(bills[i] == 10) {
                change[1] += 1;
                if(change[0] == 0) return false;
                else change[0] -= 1;
            } else if(bills[i] == 20){
                change[2] += 1;
                if(change[1] > 0 && change[0] > 0){
                    change[1] -= 1;
                    change[0] -= 1;
                } else if(change[0] >= 3) {
                    change[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}