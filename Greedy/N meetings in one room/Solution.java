/*
N meetings in one room

Given one meeting room and N meetings represented by two arrays, start and end, where start[i] represents the start time of the ith meeting and end[i] represents the end time of the ith meeting, determine the maximum number of meetings that can be accommodated in the meeting room if only one meeting can be held at a time.

Input : Start = [1, 3, 0, 5, 8, 5] , End = [2, 4, 6, 7, 9, 9]
Output : 4
Explanation : The meetings that can be accommodated in meeting room are (1,2) , (3,4) , (5,7) , (8,9).

Input : Start = [10, 12, 20] , End = [20, 25, 30]
Output : 1
Explanation : Given the start and end time, only one meeting can be held in meeting room.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private class Meeting implements Comparable<Meeting> {
        public int start;
        public int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other){
            int res = Integer.compare(this.end, other.end);
            if(res == 0){
                res = Integer.compare(this.start, other.start);
            }
            return res;
        }


    }
    
    public int maxMeetings(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            meetings.add(new Meeting(start[i], end[i]));
        }

        Collections.sort(meetings);

        List<Meeting> finalMeetings = new ArrayList<>();
        int lastEndTime = -1;
        for(Meeting meeting: meetings){
            if(finalMeetings.isEmpty() || lastEndTime < meeting.start){
                finalMeetings.add(meeting);
                lastEndTime = meeting.end;
            }
        }

        return finalMeetings.size();
    }
}