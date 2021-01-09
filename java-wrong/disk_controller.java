import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Job> pqueue = new PriorityQueue<>();
        for(int i=0; i<jobs.length ;i++){
            pqueue.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        for(Job e : pqueue){
            System.out.println(e.toString());
        }
        
        int end = 0;
        for(Job e : pqueue){
            end = e.getStart() + e.getDuration();
            if(end > e.getStart()) {
                end += e.getDuration();
            }
            answer += end;
        }
        
        answer /= 3;
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
    
    public int compareTo(Job j){
        if(this.duration < j.duration){
            return -1;
        }else if(this.duration == j.duration){
            return 0;
        }else {
            return 1;
        }
    }
    
    public String toString(){
        return String.format("start : %d, duration : %d", this.start, this.duration);
    }
}