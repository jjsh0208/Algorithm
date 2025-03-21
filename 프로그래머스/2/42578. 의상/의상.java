import java.util.*;

class Solution {

    private final HashMap<String,Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        
        initMap(clothes);
     
        return totalCase(map.values().toArray(new Integer[0]));
    }
    
    
    private void initMap(String[][] clothes){
         for(String[] c : clothes){
            map.put(c[1] , map.getOrDefault(c[1],0) + 1);   
        }
    }
    
    
    private int totalCase(Integer[] counts){
        int totalCase = 1;
        for(int cnt : counts){
            
            totalCase *= (cnt + 1);
        }
        
        return totalCase - 1;
    }
    
}