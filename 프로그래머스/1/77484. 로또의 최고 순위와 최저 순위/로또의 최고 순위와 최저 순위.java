class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // lotto 민우의 로또
        // 당첨 번호 win_nums
        int[] answer = new int[2];
        
        int[] rank = {6,6,5,4,3,2,1};
        
        int zero = 0 , cnt = 0;
        
        for(int i : lottos){
            if(i == 0) zero++;
        }
        
        for(int i = 0; i <lottos.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }
        
        answer[0] = rank[cnt + zero];
        answer[1] = rank[cnt];
        
    
        return answer;
    }
}