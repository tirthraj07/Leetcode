import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private class Interval implements Comparable<Interval>{
        public int start;
        public int end;
        public int idx;
        public Interval(int start, int end, int idx){
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Interval other){
            int res = Integer.compare(this.end, other.end);
            if(res == 0){
                res = Integer.compare(this.start, other.start);
                if(res == 0){
                    res = Integer.compare(this.idx, other.idx);
                }
            }
            return res;
        }
        
    }   

    public int eraseOverlapIntervals(int[][] intervals) {
        
        List<Interval> intervalList = new ArrayList<>();

        for(int i = 0; i<intervals.length; i++){
            int[] interval = intervals[i];
            intervalList.add(new Interval(interval[0], interval[1], i));
        }


        Collections.sort(intervalList);

        List<Interval> finalIntervals = new ArrayList<>();
        int lastEndTime = -1;

        for(Interval interval: intervalList){
            if(finalIntervals.isEmpty() || lastEndTime <= interval.start){
                finalIntervals.add(interval);
                lastEndTime = interval.end;
            }
        }

        return intervalList.size() - finalIntervals.size();
    }
}