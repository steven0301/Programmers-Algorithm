import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int tempEnd = -30001;
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        for(int[] e : routes){
            if(tempEnd < e[0]){
                tempEnd = e[1];
                answer++;
            }
        }
        
        return answer;
    }
}