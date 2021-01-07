import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // PriorityQueue를 사용하지 않고 ArrayList를 사용하면, 효율성을 통과할 수 없다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length ;i++){
            queue.add(scoville[i]);
        }

        int cnt = 0;
        while(queue.size() > 1){
            int first = queue.poll();
            if(first >= K) return cnt;
            int second = queue.poll();
            queue.add(first + 2*second);
            cnt++;
        }

        if(queue.peek() < K) return -1;
        return cnt;
    }
}