import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int solution(String[][] clothes) {
        
        HashMap<String,Integer> map = new HashMap<>();
        int answer = 1;
        
        for(String[] item  : clothes){
      
            String type = item[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);    
        }
        
        for(int value: map.values()){
      
            answer *= (value + 1);    
        }
        
       return answer - 1;
    }
    
    
  
    
    
}