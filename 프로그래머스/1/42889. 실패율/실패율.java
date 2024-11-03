import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] challenger = new int[N + 2];
        
        for(int i = 0; i < stages.length; i++){
            challenger[stages[i]] += 1; 
        }
        
        HashMap<Integer,Double> fials = new HashMap<>();

        double total = stages.length;
        
        for(int i = 1; i <= N; i++){
            if(challenger[i] == 0){ //도전한 사람이 없는 경우
                fials.put(i,0.);
            }
            else{
                fials.put(i,challenger[i] / total); //실패율 구하기
                total -= challenger[i]; //다음 스테이지의 실패율을 구하기위해 현재 스테이지의 인원을 뺌
            }
        }        
        return fials.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry :: getKey).toArray();
    }
}