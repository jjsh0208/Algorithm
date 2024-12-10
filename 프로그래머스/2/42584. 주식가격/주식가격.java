import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        // 가격이 떨어지는 순간을 저장할 배열
        int[] answer = new int[n];
        
        // 스택을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 초기값
        
        for(int i = 1; i < n; i++){
            // 각 prices[i]에 대해 prices[stack.peek()] 와 비교한다.
            // prices[i]가 더 작은 경우가 주식 가격이 떨어지는 순간이다.
            // 이때 prices[stack.peek()]의 길를 확정하고 pop한다.
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int j = stack.pop();
                
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        
        // 모든 과정이 끝났을 때 stack에 끝까지 남은 인덱스에 해댕하는 가격들은 끝까지 가격이
        // 떨어지지 않는다고 볼 수 있다. 따라서 기간을 한번에 구할 수 있다.
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        
        return answer;
    }
}