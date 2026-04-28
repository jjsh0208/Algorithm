import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
  
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> totalPlayMap = new HashMap<>();
        HashMap<String,ArrayList<Song>> songMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int playTime = plays[i];
            
            totalPlayMap.put(genre, totalPlayMap.getOrDefault(genre , 0) + playTime);
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new Song(i,playTime));
        }
        
        ArrayList<String> genrList = new ArrayList<>(totalPlayMap.keySet());
        Collections.sort(genrList, (o1,o2) -> totalPlayMap.get(o2) - totalPlayMap.get(o1));
        
        
        ArrayList<Integer> result = new ArrayList<>();
        for(String key : genrList){
            
            ArrayList<Song> songList = songMap.get(key);
            
            Collections.sort(songList);
            
            int limit = Math.min(songList.size(), 2);
            
            for(int i = 0; i < limit; i++){
                result.add(songList.get(i).id);
            }
        }    
        
        return result.stream().mapToInt( i -> i).toArray();    
    }
    
    class Song implements Comparable<Song>{
        int id;
        int play;
        
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }
        
        public int compareTo(Song other) {
            if (this.play == other.play) {
                return this.id - other.id;
            }
            return other.play - this.play;
        }
    }
}