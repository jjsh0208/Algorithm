class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        // 공백으로 분리한 문자의 첫글자를 대문자로 변경
        // 알파벳이 아닌경우 이어지는 글자를 소문자로 변경
        
        String[] ary = s.split(" ");
      
        for(int i = 0; i < ary.length; i++){
            String item = ary[i];
            
            if(item.length() == 0){
                sb.append(" ");
            }
            else{
                sb.append(item.substring(0,1).toUpperCase());
                sb.append(item.substring(1,item.length()).toLowerCase());
                sb.append(" ");
            }
            
        }
        
        if(sb.substring(s.length()-1, s.length()).equals(" ")){
            return sb.toString();
        }
        
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}