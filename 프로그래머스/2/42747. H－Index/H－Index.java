import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] citations) {
        
        citations = IntStream.of(citations)
           .boxed() // int -> Integer 변환
                .sorted(Collections.reverseOrder()) // 내림차순 정렬
                .mapToInt(Integer::intValue) // Integer -> int 변환
                .toArray();
        
        for(int i = 0; i < citations.length; i++){
            if(citations[i] < i + 1){
               return i;
            }
            
        }    
        return citations.length;
    }
}