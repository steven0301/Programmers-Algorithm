import java.util.PriorityQueue;

public class disk_controller {
    public static void main(String[] args){
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(2);     
        priorityQueue.offer(1);    
        priorityQueue.offer(3);  

        // for(int i=0; i<priorityQueue.length ;i++){

        // }

        priorityQueue.poll();

        for(int e : priorityQueue){
            System.out.println(String.format("e : %d", e));
        }

    }


}
