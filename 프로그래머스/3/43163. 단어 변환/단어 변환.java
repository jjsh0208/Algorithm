import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        // 현재의 글자와 진입하려는 글자가 하나만 차이 나는지 검사 하고 진입
        // 중복 검사를 해야할듯
        // 최소의 간격을 찾는거라 bfs 가 적합하다 판단
        
        boolean check = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)) check = true;
        }
        
        if(!check) return 0;

        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words){
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(begin,0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            String crrentWord = node.word;
            
            if(crrentWord.equals(target)){
                return node.cnt;
            }
            
            for(int i = 0; i < words.length; i++){
                String word = words[i];
                
                if(isValid(crrentWord,word)){
                    queue.add(new Node(word,node.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean isValid(String crrentWord, String word){
        int diffCnt = 0;
        
        for(int i = 0; i < word.length(); i++){
            if(crrentWord.charAt(i) != word.charAt(i)){
                diffCnt++;
            }
        }
        
        if(diffCnt > 1) return false;
        
        return diffCnt == 1;

    }
    
    class Node{
        String word;
        int cnt;
        
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    
}