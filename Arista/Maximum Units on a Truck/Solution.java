import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1,b2) ->{
            return Integer.compare(b2[1], b1[1]);
        });

        int maxUnits = 0;
        for(int[] box: boxTypes){
            if(truckSize == 0){
                break;
            }

            int boxesTaken = Math.min(truckSize, box[0]);
            truckSize -= boxesTaken;
            maxUnits += box[1] * boxesTaken;
        }

        return maxUnits;

    }
}