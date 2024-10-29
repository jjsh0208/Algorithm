import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
    
    
        
        return set.stream().sorted().mapToInt(Integer :: intValue).toArray();
    }
}