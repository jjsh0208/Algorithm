import java.util.List;
import java.util.ArrayList;

class Solution {
    
    // A, E, I, O, U
    // 1, 2, 3, 4, 5
    // AAAE = 10
    ArrayList<String> list;
    String[] words = {"A","E","I","O","U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        
        for(int i = 0; i < 5; i++){
            dfs("");
        }
     
        
        return list.indexOf(word);
    }
    
    private void dfs(String nowWord){
        
        if(nowWord.length() > 5) return;
    
        list.add(nowWord);
        
        for(int i = 0; i < 5; i++){
            dfs(nowWord + words[i]);
        }
            
    }
        
}
    