import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // k 는 짝수 단위로 나온는듯
        // 동일한 크기가 존재하는 경우 + 2
        // 동일한 크기가 존재하지않는 경우는 제외
        // 해시맵 사용
        
        int sum = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : tangerine){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        
        
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        
        
        for(int v : values){
            if(sum + v >= k){
                cnt++;
                break;
            }else{
                sum += v;
                cnt++;
            }
        }
     
        return cnt;
    }
}