import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private class Interval implements Comparable<Interval> {
        public int start;
        public int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other){
            int res = Integer.compare(this.start, other.start);
            if(res == 0){
                res = Integer.compare(other.end, this.end);
            }
            return res;
        }

    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = new ArrayList<>();

        for(int[] interval: intervals){
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        intervalList.add(new Interval(newInterval[0], newInterval[1]));


        Collections.sort(intervalList);

        List<Interval> finalIntervals = new ArrayList<>();
        int lastEndTime = -1;

        for(Interval interval: intervalList){
            if(finalIntervals.isEmpty() || lastEndTime < interval.start){
                finalIntervals.add(interval);
                lastEndTime = interval.end;
            } else {
                finalIntervals.get(finalIntervals.size() - 1).end = Math.max(finalIntervals.get(finalIntervals.size() - 1).end, interval.end);
                lastEndTime = finalIntervals.get(finalIntervals.size() - 1).end;
            }
        }

        int[][] sol = new int[finalIntervals.size()][2];
        for(int i=0; i<finalIntervals.size(); i++){
            sol[i][0] = finalIntervals.get(i).start;
            sol[i][1] = finalIntervals.get(i).end;
        }

        return sol;

    }
}