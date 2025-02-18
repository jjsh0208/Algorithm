import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> keyped = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                if(keyped.containsKey(c)){
                    int idx = keyped.get(c);
                    keyped.put(c, Math.min(idx, j+ 1));
                }else{
                    keyped.put(c , j + 1);
                }
            }
        }
        
        
         for (int i = 0; i < targets.length; i++){
             String target = targets[i];
             int cnt = 0;
             boolean flag = true;
             
             for(char c : target.toCharArray()){
                 if(keyped.containsKey(c)){
                     cnt += keyped.get(c);
                 }else{
                     flag = false;
                     break;
                 }
             }
             
             
             answer[i] = flag == false ? -1 : cnt;
         }
        
        return answer;
    }
}