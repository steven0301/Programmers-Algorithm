import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        // 대기 트럭 : Queue로 선언
        Queue<Integer> waitingQueue = new LinkedList<>();
        for(int i=0; i<truck_weights.length ;i++){
            waitingQueue.add(truck_weights[i]);
        }
        // 도로 위에 있는 트럭 : Deque로 선언
        Deque<Truck> queue = new ArrayDeque<>();
        
        int time = 0;
        // 도로 위 또는 대기 장소의 트럭이 모두 이동했을 경우에 종료
        while(!(waitingQueue.isEmpty() && queue.isEmpty())){
            
            // 다리 위에서 이동한 거리가 다리의 길이와 같으면, 다리 무게제한 원상복귀
            // ** 주의 : queue와 waitingQueue 블록의 순서가 바뀌면 오답이 발생한다!
            if(!queue.isEmpty() && queue.peek().distance == bridge_length){
                weight += queue.poll().weight;
            }
            
            // 다리가 무게를 지탱 가능하면, 다리를 지나는 트럭 무리에 추가 및 다리 무게제한 변경
            if(!waitingQueue.isEmpty() && weight-waitingQueue.peek() >= 0) {
                weight -= waitingQueue.peek();
                queue.add(new Truck(waitingQueue.poll(),0));
            }
            
            // 1초에 1씩 움직이므로, 다리위의 트럭들의 거리를 각각 +1
            for(Truck t : queue){
                t.distance += 1;
            }
            time++;
        }
        
        return time;
    }
}

class Truck {
    public int weight;
    public int distance;
    
    Truck(int weight, int distance){
        this.weight = weight;
        this.distance = distance;
    }
}