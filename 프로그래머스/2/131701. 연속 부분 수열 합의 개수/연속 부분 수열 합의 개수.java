import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int n = elements.length;
 
        int[] extendedElements = new int[n * 2];
        
        for(int i = 0; i< elements.length; i++){
            extendedElements[i] = elements[i];
            extendedElements[i + elements.length] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        //시작 인덱스
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                for(int k = 0; k < i; k++){
                    sum += extendedElements[j + k];
                }
                set.add(sum);
            }
        }
        
        
        return set.size();
    }
}