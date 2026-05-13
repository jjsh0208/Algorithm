class Solution {
    public int solution(int n) {
        // 가로의 길이는 60000이 이하
        // 경우의 수를  1,000,000,007으로 나눠라
        
        // 결론은 1과 2로 바닥을 쌓아서 
        // 어떻게 가로와 세로로 구분하지?
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        
   
        return dp[n];
    }
}