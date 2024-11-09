class Solution {
    
    // 원하는 카드 뭉치에서 카드를 순서대로 한장씩 사용
    // 한번 사용한 카드 다시 사용 불가
    // 카드를 사용하지않고 넘어가지못함
    // 카드 뭉치의 순서를 바꿀 수 없음

    public String solution(String[] cards1, String[] cards2, String[] goal) {
       
        int c1 = 0;
        int c2 = 0;
        
        for(String g : goal){
             if(c1 < cards1.length && cards1[c1].equals(g)){
                 c1++;
             }else if(c2 < cards2.length && cards2[c2].equals(g)){
                 c2++;
             }else{
                 return "No";
             }
        }
        
        return "Yes";
    }
    
    
    
    
}