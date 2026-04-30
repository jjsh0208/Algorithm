import java.util.HashSet;

class Solution {
    
    boolean[] visited;
    HashSet<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
    
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        
        dfs("",numbers);
        
        for(int i : set){
            if(isPrimeNumber(i)){
                answer++;
            }
        }
       
        return answer;
    }
    
    
    private void dfs(String crrent, String numbers){
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                
                
                set.add(Integer.parseInt(crrent + numbers.charAt(i)));
                dfs(crrent + numbers.charAt(i),numbers);
                
                visited[i] = false;
            }
        }
        
    }
    
    private boolean isPrimeNumber(int number){
        
        if(number < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}