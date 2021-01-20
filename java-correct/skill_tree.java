class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 주의 : 어떤 것 부터 for문을 시작할지 생각.
        for(int i=0; i<skill_trees.length ;i++){
            String str = skill_trees[i];
            int idx = 0;
            boolean flag = true;
            for(int j=0; j<skill_trees[i].length() ;j++){
                // 중요 : "CBD"를 기준으로 "BACDE"의 각 원소를 하나씩 비교한다.
                if(idx < skill.indexOf(skill_trees[i].charAt(j))){
                    flag = false;
                    break;
                }else if(idx == skill.indexOf(skill_trees[i].charAt(j))) idx++;
            }
            if(flag) answer++;
        }

        return answer;
    }
}