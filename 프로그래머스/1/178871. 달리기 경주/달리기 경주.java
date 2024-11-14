import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
    
    HashMap<String,Integer> map = new HashMap<>();
    
    for(int i = 0; i < players.length; i++){
        //각 선수의 이름과 인덱스를 맵으로 저장
        map.put(players[i],i);
    }
        
    for(String player : callings){
        
        //해설진이 부른 선수의 등수를 가져옴
        int rangking = map.get(player);
        
        String frontPlayer = players[rangking - 1];
        
        map.replace(frontPlayer,rangking);
        
        players[rangking] = frontPlayer;
        
    
        map.replace(player, rangking - 1);
        players[rangking - 1] = player;
        
    }
        
        return players;
    }
}