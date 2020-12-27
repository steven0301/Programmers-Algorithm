import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        // numbers : "17" or "011"
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numbers.length(); i++){
            char ch = numbers.charAt(i);
            int a = Character.getNumericValue(ch);
            list.add(a);
        }
        
        // permutation 로직 사용을 위해서 list -> arr 변경
        int[] temp = new int[list.size()];
        for(int i=0; i<temp.length ;i++){
            temp[i] = list.get(i);
        }
        
        Set<Integer> answerSet = new HashSet<>();
        for(int i=1; i<=temp.length ;i++){
            permutation(temp, 0, temp.length, i, answerSet);
        }
                
        answer = answerSet.size();
        return answer;
    }
    
    public static boolean checkPrime(int num){
        if(num == 0 || num == 1) return false;
        for(int i=2; i<num ;i++){
            if(num != 0 && num%i == 0) return false;
        }
        return true;
    }
        
    public static void permutation(int[] arr, int depth, int n, int r, Set<Integer> answerSet){
        if(depth == r){
            addAnswer(arr, r, answerSet);
            return;
        }else {
            for(int i=depth; i<n ;i++){
                swap(arr, i, depth);
                permutation(arr, depth+1, n, r, answerSet);
                swap(arr, i, depth);
            }
        }
    }
    
    // answer Set에 추가하여 중복되는 소수를 제거하기 위함
    public static void addAnswer(int[] arr, int r, Set<Integer> answerSet){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r ;i++){
            sb.append(arr[i]);
        }
        int num = Integer.parseInt(sb.toString());
        if(checkPrime(num)) answerSet.add(num);
    }
    
    // swap 적용시 순서 조심
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}