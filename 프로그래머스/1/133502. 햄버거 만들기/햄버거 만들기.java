import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> li = new ArrayList<>();
        
        for(int i : ingredient){
            li.add(i);
            while(li.size() >= 4){
                int n = li.size();
                
                // 재료의 수가 4개 이상일 때 뒤에서 부터 순서가 맞는 거 검사
                if(!(li.get(n - 1) == 1 &&
                   li.get(n - 2) == 3 &&
                   li.get(n - 3) == 2 &&
                   li.get(n - 4) == 1))
                    break;
                
                for(int j = 0; j < 4; j++){
                   li.remove(li.size() - 1);
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}