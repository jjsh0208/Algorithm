class Solution {
    public int solution(int[] arr) {
        // n개의 수를 공약수로 나눈다. 나누어 떨어지는 수는 그대로 내려온다.
        // 모든 몫이 서로소이면 stop
        // 왼쪽 공약수와 아래 서로소를 모두 곱한다.
        
        int gcd = gcd(arr[0],arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        
        for(int i = 2; i < arr.length; i++){
            gcd = gcd(lcm,arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
            
        return lcm;
    }
    
    
    public int gcd(int n1 , int n2){
        if(n1 % n2 == 0){
            return n2;
        }
        
        return gcd(n2, n1 % n2);
    }
    
}