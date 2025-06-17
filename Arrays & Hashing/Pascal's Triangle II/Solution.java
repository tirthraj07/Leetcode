import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        int row = rowIndex + 1;
        for(int col = 2; col <= row; col++){
            // had to upcast to double due to edge case of (res*(row-col+1)) going off the Integer.MAX_VALUE
            double res = rowList.getLast();
            res = (res * (row - col + 1))/(col - 1);
            rowList.add((int)res);
        }
        return rowList;
    }
}