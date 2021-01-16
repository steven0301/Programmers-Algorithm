class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while(n != 0){
            int temp = n%3;
            n /= 3;
            
            // 3으로 나누어 떨어질 경우, 몫에서 하나 빼준다.
            if(temp == 0) n--;
            answer = numbers[temp] + answer;
        }
        
        return answer;
    }
}