class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target,0,0);
        // 원본 배열
        // 찾을 수
        // 현재 인덱스
        // 타겟을 찾은경우
        
    } 
    
    
    private int dfs(int[] numbers, int target, int idx, int num){
        if(idx == numbers.length){
            if(num == target){
                return 1;
            }else{
                return 0;
            }
        }
        
        return dfs(numbers, target, idx + 1, num + numbers[idx]) + 
               dfs(numbers, target, idx + 1, num - numbers[idx]);
        
        
        
    }

}
