class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // lost, reserver 중복시 -1 처리를 함으로써 제거함
        for(int i=0; i<reserve.length ;i++){
            for(int j=0; j<lost.length ;j++){
                if(reserve[i] == lost[j]){
                    reserve[i] = lost[j] = -1;
                    break;
                }
            }
        }

        // 
        for(int i=0; i<reserve.length ;i++){
            for(int j=0; j<lost.length ;j++){
                if(lost[j] == reserve[i]+1 || lost[j] == reserve[i]-1){
                    reserve[i] = lost[j] = -1;
                    break;
                }
            }
        }

        int cnt = 0;
        for(int l : lost){
            if(l != -1) cnt++;
        }

        answer = n - cnt;
        return answer;
    }
}