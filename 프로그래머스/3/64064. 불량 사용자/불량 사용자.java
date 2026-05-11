import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    
    // user_id 당첨자 목록
    // benned_id 불량 사용자 목록
    
    Set<String> set;
    boolean[] visited;
    String[] temp;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
    
        set = new HashSet<>();
        visited = new boolean[user_id.length];
        temp = new String[banned_id.length];
        
        dfs(0, user_id, banned_id);
        
        return set.size();
    }
    
    private void dfs(int depth, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            
            String[] clone = temp.clone();
            
            Arrays.sort(clone);
            
            String resultString = String.join(" ", clone);
            set.add(resultString);
            
            return;
        }

        String banPattern = banned_id[depth].replace("*",".");
        
        for(int i = 0; i < user_id.length; i++){
            if(!visited[i] && isNameCheck(user_id[i], banPattern)){
                visited[i] = true;
                temp[depth] = user_id[i];
                
                dfs(depth + 1, user_id,banned_id);
                
                visited[i] = false;
            }
        }
        
    }
    
    
    private boolean isNameCheck(String name, String banUser){
        // 정규 표현식으로 .는 임의의 문자 하나를 뜻함
        
        if(name.length() != banUser.length()) return false;
        
        return name.matches(banUser);
        
        
    }
}