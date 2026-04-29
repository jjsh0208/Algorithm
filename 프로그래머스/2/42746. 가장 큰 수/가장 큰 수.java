import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder(); 
        String[] str = new String[numbers.length];
        
        int j = 0;
        for(int i : numbers){
            str[j++] = String.valueOf(i);
        }
        
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                return (b + a).compareTo(a + b);
            }
        });
        
        if(str[0].equals("0")){
            return "0";
        }
        
        for(String s: str){
            sb.append(s);
        }
        
        return sb.toString();
    }
}