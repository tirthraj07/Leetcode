import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = intervals.length;
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while(i < l && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        while(i < l && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i < l) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][2]);
    }
}