class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 전체 면적
        // s = yellow  + brown ==  width x height
                
        int[] answer = new int[2];
        int sum = brown + yellow; // 전체 면적
        
        // 노란색 구하는 공식
        // y =  width-2 x height - 2
        // 그러면 가로와 세로값을 구하는 방법
        // 세로는 최소 3부터 있어야 노란색이 존재할 수 있음
        // 3부터 수를 비교하며 곱한 값이 전체 면적과 같으면 그 수가 가로와 세로이다.
        
       for(int height = 3; height <= sum; height++){
          // 전체 면적에서 높이가 나누어 떨어져야 사각형임
          if(sum % height == 0){
                int width = sum / height;
                
                // 구한 가로와 구한 세로를 -2 한뒤 곱해서 노란색 면적 계산
                int y = (width - 2) * (height - 2);
                
                // 실제 노란색 면적과 같으면 정답
                if(y == yellow){
                    // 둘중 더 큰 값이 가로가 되어야함
                    // 둘중 더 작은 값이 세로가 되어야함
                    answer[0] = Math.max(width,height);
                    answer[1] = Math.min(width,height);
                    break;
                }
               
           }
       }
        
    
        return answer;
    }
}