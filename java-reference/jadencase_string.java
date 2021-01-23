import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String str = st.nextToken().toString();
            char[] arr = str.toCharArray();
            for(int i=0; i<arr.length ;i++){
                if(i==0){
                    sb.append(Character.toUpperCase(arr[i]));
                }else {
                    sb.append(Character.toLowerCase(arr[i]));
                }
            }
            sb.append(' ');
        }
        
        
        return sb.toString();
    }
}