import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        char[] charX = X.toCharArray();
        char[] charY = Y.toCharArray();
        Arrays.sort(charX);
        Arrays.sort(charY);
        
        
        StringBuilder sb = new StringBuilder();
        int idxX = charX.length - 1;
        int idxY = charY.length - 1;
        
        while(idxX >= 0 && idxY >= 0){
            
            if(charX[idxX] == charY[idxY]){
                sb.append(charX[idxX]);
                
                idxX--;
                idxY--;
            } else if (charX[idxX] > charY[idxY]){
                idxX--;
            } else{
                idxY--;
            }
        }
        
        
        if(sb.length() == 0 ) return "-1";
        
        if(sb.toString().matches("0+")){
            return "0";
        }
        
        
        return sb.toString();
    }
}