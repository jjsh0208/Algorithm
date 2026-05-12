class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        
        int[] answer = new int[n];
        
        // 2. 숫자를 최대한 균등하게 나누기 위해 몫과 나머지 계산
        int quotient = s / n; // 4
        int remainder = s % n; // 1
        
        // 모든 수가 최대한 균등하게 분포할 때 곱이 최대가 됨
        for(int i = 0; i < n ;i ++){
            answer[i] = quotient;
        }
        
        //남은 나머지(remainder)의 개수만큼, 배열의 뒤에서부터 1씩 분배
        for(int i = n - 1; i >= n - remainder; i--){
            answer[i]++;
        }
        
        return answer;
        
    }
}