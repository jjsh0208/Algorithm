import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        // 각 열에 대한 스택을 생성한다.
        Stack<Integer>[] stack = new Stack[board.length];
        for(int i = 0; i < stack.length; i++){
            stack[i] = new Stack<>();
        }
        
        // board를 역순으로 탐색하며, 각 열의 인형을 stack에 추가함
        for(int i = board.length - 1; i >= 0; i--){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] > 0){
                    stack[j].push(board[i][j]);
                }
            }
        }
        
        // 인형을 담을 stack 생성
        Stack<Integer> bucket = new Stack<>();
        // 사라진 인형의 총 개수를 저장할 변수를 초기화
        int answer = 0;
        
        // moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가한다.
        for(int move : moves){
            if(!stack[move - 1].isEmpty()){ // 해당 열에 인형이 있는 경우
                int doll = stack[move - 1].pop();
                
                // bucket에 인형이 있고, 가장 위에있는 인형과 같은 경우 
                if(!bucket.isEmpty() && doll == bucket.peek()){ 
                    bucket.pop();
                    answer += 2;
                }
                else{ // 바구니 인형이 없거나, 가장 위에 있는 인형과 다른 경우 push한다.
                    bucket.push(doll);
                }
            }
        }
        
        
        
        return answer;
    }
}