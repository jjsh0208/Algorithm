import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            int n = choices[i];
            
            
            if(i > 0 && i < 4){
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + 4 - n);
            }else{
               char c = survey[i].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + n - 4); 
            }
        }
        
        return new StringBuilder()
            .append(map.getOrDefault('R',0) >= map.getOrDefault('T',0) ? 'R' : 'T')
            .append(map.getOrDefault('C',0) >= map.getOrDefault('F',0) ? 'C' : 'F')
            .append(map.getOrDefault('J',0) >= map.getOrDefault('M',0) ? 'J' : 'M')
            .append(map.getOrDefault('A',0) >= map.getOrDefault('N',0) ? 'A' : 'N')
            .toString();
    }
}