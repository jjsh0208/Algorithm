class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        
        // 라운드가 끝나면 n / 2 
        // n 은 2의 지수 ( 부전승 없음 )
        
        // 1 2 , 3 4 , 5 6 , 7 8
        // 1 4 , 5 7 
        // 4 7
        
        
        while(true){
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            
            if(a == b) break;
            
        }

        return answer;
    }
}