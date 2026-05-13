class Solution {
    public int solution(int n) {
        if(n % 2 == 1){
            return 0;
        }

        if(n == 2){
            return 3;
        }
        
        long[] dp = new long[n + 1];
        long mod = 1000000007;
        dp[0] = 1; // 특수 패턴
        dp[2] = 3; // 2인 패턴
    
        
        for(int i = 4; i <= n; i += 2){
            dp[i] = (dp[i - 2] * 4 - dp[i - 4]) % mod;
            
            // 뺄셈 연산으로 인해 발생할 수 있는 음수 값 보정
            if (dp[i] < 0) {
                dp[i] += mod;
            }
        }
    
        
        return (int)dp[n];
    }
}