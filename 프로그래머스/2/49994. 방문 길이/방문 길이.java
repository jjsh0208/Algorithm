import java.util.HashMap;
import java.util.HashSet;

//중복 경로는 최종 길이에 포함하지않는다.
// 해시셋 사용
class Solution {
    
    private static final HashMap<Character,int[]> location = new HashMap<>();

    private static boolean isValidMove(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
        
    private static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }
    
    public int solution(String dirs) {
        initLocation();
        
        // 시작 좌표
        int x = 5, y = 5;
        
        //겹치는 좌표를 처리할 HashSet
        HashSet<String> answer = new HashSet<>(); 
        
        for(int i = 0; i < dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if(!isValidMove(nx,ny)){
                continue;
            }
            
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
    
        }
        
        return answer.size() / 2;
    }
}