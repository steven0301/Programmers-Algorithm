import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업 대기 큐 : start 오름차순
        LinkedList<Job> waitingQueue = new LinkedList<>();
        for(int i=0; i<jobs.length ;i++){
            waitingQueue.offer(new Job(jobs[i][0], jobs[i][1]));
        }
        
        Collections.sort(waitingQueue, new Comparator<Job>(){
            public int compare(Job j1, Job j2){
                // return j1.getStart().compareTo(j2.getStart());
                return j1.getStart() - j2.getStart();
            }
        });
        
        // 작업 우선순위 큐 : Comparable에 의해, duration 오름차순
        PriorityQueue<Job> pqueue = new PriorityQueue<>();
        
        int end = waitingQueue.peek().getStart();
        int init = waitingQueue.peek().getStart();
        for(int i=0; i<waitingQueue.size(); ){
            while(!waitingQueue.isEmpty() && waitingQueue.peek().getStart() <= end){
                pqueue.add(waitingQueue.poll());
            }
            
            if(pqueue.isEmpty()) {
                end++;
                continue;
            }
            
            while(!pqueue.isEmpty()){
                Job job = pqueue.poll();
                // System.out.println(job);
                end += job.getDuration();
                answer += end - job.getStart();
                i++;
            }
        }
        
        answer /= jobs.length;
        return answer;
    }
}

class Job implements Comparable<Job>{
    private int start;
    private int duration;
    
    Job(int start, int duration){
        this.start = start;
        this.duration = duration;
    }
    
    public int getStart(){
        return this.start;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    @Override
    public int compareTo(Job j){
        if(this.duration < j.duration) return -1;
        else return 1;
    }
    
    public String toString(){
        return String.format("start : %d, duration : %d", this.start, this.duration);
    }
}