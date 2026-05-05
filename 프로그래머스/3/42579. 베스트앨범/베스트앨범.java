import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 많이 재생된 장르
        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록
        // 3. 장르 내에서 재생 횟수가 같으면 고유 번호가 낮은 순으로 처리 (index)
        // 4. 장르별 노래는 두개씩이다.
        
        HashMap<String,Integer> totalPlay = new HashMap<>(); // 각 장르별 총 재생 횟수
        HashMap<String,ArrayList<Song>> songMap = new HashMap<>(); // 각 장르별 장르 등장 횟수
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            totalPlay.put(genre, totalPlay.getOrDefault(genre,0) + play);
            
            songMap.putIfAbsent(genre,new ArrayList<>());
            songMap.get(genre).add(new Song(i,play));
        }
        
        
        ArrayList<String> genrList = new ArrayList<>(totalPlay.keySet());
        
        Collections.sort(genrList,(o1,o2) -> totalPlay.get(o2) - totalPlay.get(o1));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String grenr : genrList){
            // 장르는 플레이타임 기준으로 내림차순 되어있음 각 장르별 노래 두개 씩 꺼내됨
            
            ArrayList<Song> songList = songMap.get(grenr);
            
            Collections.sort(songList);
            
            int rimit = Math.min(songList.size(),2);
            
            for(int i = 0; i < rimit; i++){
                answer.add(songList.get(i).id);
            }   
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    
    class Song implements Comparable<Song>{
        int id;
        int playTime;
        
        public Song(int id, int playTime){
            this.id = id;
            this.playTime = playTime;
        }
        
        @Override
        public int compareTo(Song other){
            if(this.playTime == other.playTime){
                return this.id - other.id;
            }
            
            return other.playTime - this.playTime;
        }
        
    }
}