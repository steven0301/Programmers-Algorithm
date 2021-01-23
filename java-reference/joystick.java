class Solution {
    public int solution(String name) {
        int answer = 0;                  
        int[] arr = new int [name.length()];
        
        for(int i=0; i<name.length() ;i++){
            char ch = name.charAt(i);
            if(ch == 'A'){
                arr[i] = 1;
                continue;
            }
            int a = Math.abs(Integer.valueOf(ch)-Integer.valueOf('A'));
            int b = Math.abs(Integer.valueOf('Z')-Integer.valueOf(ch)+1);
            answer += Math.min(a,b);
        }
        
        int startIdx = 0;
        int endIdx   = 0;
        for(int i=0; i<arr.length ;i++){
            if(arr[i] == 1){
                startIdx = i;
            }else {
                endIdx = i;
                if(i == arr.length)
                    startIdx = 0;
            }
        }
        
        answer += name.length()-1;
        if(startIdx != 0 && startIdx < endIdx){
            answer -= (endIdx - startIdx);
        }
        return answer;
    }
}