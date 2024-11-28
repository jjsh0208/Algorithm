import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
      
        // 각 스테이지에 도전하는 도전자의 수를 저장하는 배열
        int[] chellenger = new int[N + 2];
        
        // 해당 스테이지에 도전하는 도전자의 수를 저장
        for(int i = 0; i < stages.length; i++){
            chellenger[stages[i]] +=1;
        }
        
        // 실패율을 저장할 해시맵 (스테이지 , 실패율)
        HashMap<Integer, Double> fails = new HashMap<>();
        
        // total 사용자의 수
        // double / int 를 해야 실수로 결과가 나오기때문에 double로 선언
        double total = stages.length;
        
        //스테이지 1 부터 마지막 스테이지 까지 반복
        for(int i = 1; i <= N;i++){
            //해당 스테이지의 도전한 사람이 없는 경우 (스테이지 , 0.0)
            if(chellenger[i] == 0){
                fails.put(i,0.);
            }
            //해당 스테이지의 도전자가 있는 경우 
            //(스테이지 , 현재 스테이지 도전자 / 현재 스테이지 도달한 사용자)
            else{  
                fails.put(i, chellenger[i] / total);
                //다음 스테이지 실패율을 구하기 위해 현재 스테이지 인원 제외
                total -= chellenger[i];
            }
        }
        // 1. entrySet()으로 HashMap의 Entry Set을 가져옴 (Set<Map.Entry<Integer,Double>>)
        // 2. stream()으로 스트림 생성
        // 3. sorted()로 값 기준 내림차순 정렬
        // 4. mapToInt()로 각 Entry의 키를 IntStream으로 변환
        // 5. toArray()로 int[] 배열 반환
        
        return fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(),o1.getValue())).mapToInt(HashMap.Entry :: getKey).toArray();
    }
}