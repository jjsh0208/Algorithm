import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public int[] solution(String[] park, String[] routes) {
            int[] answer = {0,0};    
            int h = park.length; // 공원의 세로 크기
            int w = park[0].length(); // 공원의 가로 크키
            
            char[][] parks = new char[h][w];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                parks[i][j] = park[i].charAt(j);
                
                if(parks[i][j] == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('N',0);
        map.put('E',1);
        map.put('S',2);
        map.put('W',3);
        
        
        int[] dh = {-1,0,1,0};
        int[] dw = {0,1,0,-1};
        
        
        for(int i = 0; i< routes.length; i++){
            char direction = routes[i].charAt(0);
            
            int value = Integer.parseInt(routes[i].split(" ")[1]);
            
            int index = map.get(direction);
            
            boolean flag = true;
            
            int nh = answer[0];
            int nw = answer[1];
            
            for(int j = 0; j < value; j++){
                nh += dh[index];
                nw += dw[index];
                
                if( nh >= h || nh < 0 || nw >= w || nw < 0){
                    flag = false;
                    break;
                }
                if(parks[nh][nw] == 'X'){
                    flag = false;
                    break;
                }
            }
            
            
            if(flag){
                answer[0] = nh;
                answer[1] = nw;
            }
        }

        return answer;
    }
}