import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator = (int[] interval1, int[] interval2) -> {
            int diff = Integer.compare(interval1[0], interval2[0]);
            if(diff == 0){
                return Integer.compare(interval1[1], interval2[1]);
            }
            return diff;
        };

        Arrays.sort(intervals, comparator);
        List<int[]> mergedIntervals = new ArrayList<>();
        
        int i = 0;
        int j = 1;
        int start = intervals[i][0];
        int end = intervals[i][1];
        while(j <= intervals.length){
            if(j == intervals.length){
                mergedIntervals.add(new int[]{start, end});
                break;
            }

            if(start <= intervals[j][0] && intervals[j][0] <= end){
                end = Math.max(end, intervals[j][1]);
            }
            else{
                mergedIntervals.add(new int[]{start, end});
                i = j;
                start = intervals[i][0];
                end = intervals[i][1];
            }
            j++;
        }

        return mergedIntervals.toArray(new int[0][]);
    }   
}