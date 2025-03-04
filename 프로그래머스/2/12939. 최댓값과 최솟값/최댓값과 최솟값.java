import java.util.Arrays;

class Solution {
    public String solution(String s) {
        
        String[] ary = s.split(" ");
        
        int max = Arrays.stream(ary)
            .mapToInt(Integer::parseInt)
            .max()
            .orElseThrow();
        
        
        int min = Arrays.stream(ary)
            .mapToInt(Integer::parseInt)
            .min()
            .orElseThrow();
    
        
        return (String) (min + " " + max);
    }
}