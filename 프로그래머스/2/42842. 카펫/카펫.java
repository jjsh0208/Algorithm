class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 전체 면적
        // s = yellow  + brown = width x height
        
        // 노란색 구하는 공식
        // y =  width-2 x height - 2
        
        // 갈색 면적
        // b = s- y
        
        int[] answer = new int[2];
        int map = brown + yellow;
      
        for(int i = 3; i <= map; i++){
            int row = i; // 세로
            int col = map / row; // 가로
            
            if(col < 3) continue; // 가로 개수 3 이하
            
            // 가로의 크기가 세로와 같거나 동일 
            if(col >= row){
                if((row - 2) * (col - 2) == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }    
            }
        }
        
        
    
        return answer;
    }
}