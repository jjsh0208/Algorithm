import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String p : participant){
            map.put(p, map.getOrDefault(p , 0) + 1);
        }

        for(String c : completion){
            map.put(c , map.getOrDefault(c, 0) - 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String key = entry.getKey();
            int cnt = entry.getValue();
            
            if(cnt != 0){
                return key;
            }
        }
       return null;
    }
}