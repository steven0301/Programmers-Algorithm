class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0; i<s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                index = 0;
            }else {
                index++;
                if(index%2 !=0) ch = Character.toUpperCase(ch);
                else ch = Character.toLowerCase(ch);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}