import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> card1Deque = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2Deque = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));
        
        // goal큐가 비어있지않는 동안 반복
        while(!goalDeque.isEmpty()){
            
            //
            if(!card1Deque.isEmpty() && card1Deque.peekFirst().equals(goalDeque.peekFirst())){
                goalDeque.pollFirst();
                card1Deque.pollFirst();
            }
            else if(!card2Deque.isEmpty() && card2Deque.peekFirst().equals(goalDeque.peekFirst())){
                goalDeque.pollFirst();
                card2Deque.pollFirst();
            }
            else {
                break;
            } 
        }
        
        if(goalDeque.isEmpty()){
            return "Yes";
        } else{
            return "No";
        }

    }
}