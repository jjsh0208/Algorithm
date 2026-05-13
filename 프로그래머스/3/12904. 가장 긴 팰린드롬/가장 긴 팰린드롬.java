class Solution
{
    public int solution(String s)
    {   
        // 각 단어를 기준점으로 삼아야한다
        // 가지치기를 위해서 시작과 끝은 제외하는게 좋을 거 같음
        // 각 단어를 기준으로 밸린드롬이 되는 애들의 최고 길이를 측정해야한다   
        int max = 0;
        for(int i = 0 ; i < s.length(); i++){
            
            int left = extend(s, i, i);
            
            // abba 처럼 중심점이 같은 문자인 경우를 생각해서 + 1
            int right = extend(s, i, i + 1);
            
            
            max = Math.max(max, Math.max(left,right));
        }
        return max;
    }
    
    
    private int extend(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}