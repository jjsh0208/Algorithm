import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    boolean[] visited;
    ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        
        Arrays.sort(tickets, (o1,o2) ->{
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
               return o1[0].compareTo(o2[0]);
        });
        
        
        answer.add("ICN");
        
        dfs("ICN",tickets,0);
        
        return answer.toArray(new String[0]);
    }
    
    private boolean dfs(String current, String[][] tickets, int depth){
        
        if(depth == tickets.length) return true;;
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && current.equals(tickets[i][0])){
                
                visited[i] = true;
                answer.add(tickets[i][1]);
                
                if(dfs(tickets[i][1],tickets, depth + 1)){
                    return true;
                
                }
                visited[i] = false;
                answer.remove(answer.size() - 1);
            }    
        }
    
        return false;
    }
    
    
}