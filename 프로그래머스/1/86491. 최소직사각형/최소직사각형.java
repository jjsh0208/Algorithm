class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0;
        int hight = 0;
        
        // 긴 변들 중에 큰 값
        // 짧은 변들 중에 큰 값
        
        for(int i = 0; i < sizes.length; i++){
            int w = Math.max(sizes[i][0] , sizes[i][1]);
            int h = Math.min(sizes[i][0] , sizes[i][1]);
            
            width = Math.max(width, w);
            hight = Math.max(hight, h);
        }
        
        return width * hight;
    }
}