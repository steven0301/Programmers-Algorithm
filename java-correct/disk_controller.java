import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
  
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업 우선순위 큐
        PriorityQueue<Job> pq = new PriorityQueue<>();
        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        // 대기 리스트
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        // 작업 우선순위 큐 없이, list 입력후 정렬해도 된다.
        // List<Job> list = new ArrayList<>();
        // for (int i = 0; i < jobs.length; i++) {
        //     // list.add(pq.poll());
        //     list.add(new Job(jobs[i][0], jobs[i][1]));
        // }
        // Collections.sort(list);
        
        // 현재시간
        int time = 0;
        
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                // duration을 우선시 하지만, 만족하는 것이 없으면 어쩔 수 없이 시작점을 비교한다.
                if (time >= list.get(i).start) {
                    time += list.get(i).duration;
                    answer += time - list.get(i).start;
                    list.remove(i);
                    break;
                }
                // 중요 : i를 끝까지 순회했는데, 만족하는 것이 없을 경우 time 증가.
                if (i == list.size()-1) time++;
            }
        }
        
        answer /= jobs.length;
        return answer;
    }
}

class Job implements Comparable<Job> {
    public int start;
    public int duration;
    
    public Job(int start, int duration) {
        this.start = start;
        this.duration = duration;
    }
    
    @Override
    public int compareTo(Job job) {
        if (this.duration > job.duration) return 1;
        if (this.duration < job.duration) return -1;
        return (this.start < job.start) ? -1 : 1 ;
    }
}