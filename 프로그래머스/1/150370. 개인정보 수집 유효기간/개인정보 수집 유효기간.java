import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // today는 오늘 날짜
        // terms는 약관의 종류 , 유효기간
        // privacies 는 개인정보 수집일자 , 약관 종류
                
        List<Integer> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
    
        for(int i = 0; i < terms.length; i++){
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        
        // 개인 정보 수집일자
        for(int i = 0; i < privacies.length; i++){
            String date = privacies[i].split(" ")[0];
            int type = Integer.parseInt(map.get(privacies[i].split(" ")[1])) * 28;
            
            int num = (year - Integer.parseInt(date.split("\\.")[0])) * 28 * 12
                + (month - Integer.parseInt(date.split("\\.")[1])) * 28
                + (day - Integer.parseInt(date.split("\\.")[2])); 
        
            if(num >= type){
                list.add(i + 1);
            }    

       
        }
     return list.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}