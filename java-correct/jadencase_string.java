class Solution {
    public String solution(String s) {
        
        char[] arr  = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char first = arr[0];
        sb.append(Character.toUpperCase(first));
        for(int i=1; i<arr.length ;i++){
            
            if(arr[i] == ' '){
                sb.append(' ');
            }else {
                if(arr[i-1] == ' '){
                    sb.append(Character.toUpperCase(arr[i]));
                }else {
                    sb.append(Character.toLowerCase(arr[i]));
                }
            }
        }
        
        return sb.toString();
    }
}