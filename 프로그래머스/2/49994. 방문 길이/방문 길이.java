import java.util.HashMap;
import java.util.HashSet;

class Solution {
    
    private static HashMap<Character,int[]> location = new HashMap<>();
    
    public int solution(String dirs) {
        initLocation();
        
        int x = 5, y = 5;
        
        HashSet<String> answer = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            int[] offSet = location.get(dirs.charAt(i));
            
            int nx = x + offSet[0];
            int ny = y + offSet[1];
            
            if(!isValidMove(nx,ny))
                continue;
            
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
    
       
        return answer.size() / 2;
    }
    
    private void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});
    }
    
    private boolean isValidMove(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
}