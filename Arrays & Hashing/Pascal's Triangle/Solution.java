import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();

        if(numRows >= 1){
            sol.add(new ArrayList<>(List.of(1)));
        }

        if(numRows >= 2){
            sol.add(new ArrayList<>(List.of(1,1)));
        }
        
        for(int row = 3; row <= numRows; row++){
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            for(int col = 2; col <= row; col++){
                int res = rowList.getLast();
                res = (res * (row - col + 1))/(col-1);
                rowList.add(res);
            }
            sol.add(rowList);
        }

        return sol;
    }
}