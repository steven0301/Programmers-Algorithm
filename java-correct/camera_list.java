import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int tempEnd = -30001;
            
        List<Node> list = new ArrayList<>();
        for(int i=0; i<routes.length ;i++){
            list.add(new Node(routes[i][0], routes[i][1]));
        }
        Collections.sort(list);
        
        for(int i=0; i<list.size() ;i++){
            if(tempEnd < list.get(i).start){
                tempEnd = list.get(i).end;
                answer++;
            }
        }
        return answer;
    }
}

class Node implements Comparable<Node>{
    public int start;
    public int end;
    
    Node(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Node n){
        return this.end - n.end;
    }
}