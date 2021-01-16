class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length ;i++){
            String str = skill_trees[i];
            int prev = 100;
            boolean flag = true;
            for(int j=0; j<skill.length() ;j++){
                char ch = skill.charAt(j);
                int idx = str.indexOf(ch);
                // 오류 : CBD순서에서 , BD만 나온 경우는 잡아내지 못한다.
                if(idx == -1) continue;
                if(prev == 100 || prev < idx){
                    prev = idx;
                }
                if(prev != 100 && prev > idx){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        return answer;
    }
}