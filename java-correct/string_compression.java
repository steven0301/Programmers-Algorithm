public class string_compression {
    public static void main(String[] args){
        String str = "abcabcabcabcdededededede";
        System.out.println(String.format("answer : %d", solution(str)));
    }

    static int solution(String s){
        int answer = s.length();
        
        // 길이를 1부터 하나씩 늘려감
        for(int i=1; i<=s.length()/2 ;i++){
            int len = s.length();
            
            // position을 이동시키면서 중복문자열 count
            for(int pos=0; pos+i<=s.length(); ){
                String unit = s.substring(pos, pos+i);
                pos += i;
                
                int cnt = 0;
                for( ; pos+i<=s.length() ; ){    
                    if(unit.equals(s.substring(pos,pos+i))){
                        cnt++;
                        pos += i;
                    }else {
                        break;
                    }
                }

                if(cnt > 0){
                    len -= i * cnt;
                    // 주의 : xxxxxxxxxxyyy의 경우 x가 10개 이지만 cnt=9 이다.
                    // 이유 : 맨 첫번째의 비교 대상이 되는 문자열은 cnt에 포함되지 않기 때문
                    if(cnt < 9) len += 1;
                    else if(cnt < 99) len += 2;
                    else if(cnt < 999) len += 3;
                    else len += 4;
                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}
