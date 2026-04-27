class Solution {
    
    final int NUMBER =  1000000007;
    public int solution(int n, int[] money) {
        int[] coin = new int[n + 1];
        coin[0] = 1;
        
        for(int m : money){
            for(int i = m; i <= n; i++){
                coin[i] = coin[i] + coin[i - m] % NUMBER;
            }
        
     
        }
           return coin[n];
    }
}