import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> card1Deque = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2Deque = new ArrayDeque<>(Arrays.asList(cards2));
        
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
      
        
        while(!goalDeque.isEmpty()){
            if(!card1Deque.isEmpty() && card1Deque.peek().equals(goalDeque.peek())){
                card1Deque.pollFirst();
                goalDeque.pollFirst();
            }else if(!card2Deque.isEmpty() && card2Deque.peek().equals(goalDeque.peek())){
                card2Deque.pollFirst();
                goalDeque.pollFirst();
            }else{
                break;
            }
        }
    
        if(goalDeque.isEmpty()){
            return "Yes";
        }else{
            return "No";
        }
    
    }
}