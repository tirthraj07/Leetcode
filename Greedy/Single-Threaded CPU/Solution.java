import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private class Task implements Comparable<Task>{
        public int enqueueTime;
        public int processingTime;
        public int idx;
        public Task(int enqueueTime, int processingTime, int idx){
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.idx = idx;
        }

        @Override
        public int compareTo(Task other) {
            int res = Integer.compare(this.enqueueTime, other.enqueueTime);
            if (res == 0) {
                res = Integer.compare(this.processingTime, other.processingTime);
                if (res == 0) {
                    return Integer.compare(this.idx, other.idx);
                }
            }
            return res;
        }

    }

    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for(int i = 0; i<tasks.length; i++){
            int[] task = tasks[i];
            taskList.add(new Task(task[0], task[1], i));
        }

        Collections.sort(taskList);


        int[] order = new int[tasks.length];
        int time = 0;
        int taskIdx = 0;
        int scheduled = 0;
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.processingTime != b.processingTime) {
                return Integer.compare(a.processingTime, b.processingTime);
            }
            return Integer.compare(a.idx, b.idx);
        });

        while(scheduled < tasks.length){
            while (taskIdx < taskList.size() && taskList.get(taskIdx).enqueueTime <= time) {
                pq.offer(taskList.get(taskIdx));
                taskIdx++;
            }
            if (pq.isEmpty()) {
                time = taskList.get(taskIdx).enqueueTime;
                continue;
            }
            Task current = pq.poll();
            order[scheduled++] = current.idx;
            time += current.processingTime;
        }
        
        return order;
    }
}