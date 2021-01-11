import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        for(int i=0; i<priorities.length ; i++){
            list.add(new Node(priorities[i], i));
        }

        while(!list.isEmpty()){
            // 첫번째 원소가 가장 큰 경우, 인쇄하면서 제거한다.
            if(list.get(0).priority >= Collections.max(list).priority){
                answer++;
                // index가 원하는 값이라면 종료
                if(list.get(0).index == location) break;
                list.remove(0);
            // 최댓값이 따로 존재하는 경우, 후순위로 미룬다.
            }else {
                Node temp = list.get(0);
                list.add(temp);
                list.remove(0);
            }
        }
        return answer;
    }
}

class Node implements Comparable<Node>{
    public int priority;
    public int index;

    Node(int priority, int index){
        this.priority = priority;
        this.index = index;
    }

    // 중요 : Collections.max()를 사용할 경우, compareTo를 사전에 정의해둬야 한다.
    @Override
    public int compareTo(Node n){
        if(this.priority > n.priority) return 1;
        else if(this.priority == n.priority) {
            return 0;
        }else {
            return -1;
        }
    }
}