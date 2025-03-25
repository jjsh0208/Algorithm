class Solution {
    public boolean solution(int x) {
        
        int n = x;
        int sum = 0;
        while(n >= 1){
            sum += n % 10;
            n /= 10;
        }
        

        return x % sum == 0;
    }
}