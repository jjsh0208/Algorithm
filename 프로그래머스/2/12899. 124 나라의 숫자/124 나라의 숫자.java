class Solution {
    public String solution(int n) {
        //1
        //2
        //4
        //11
        //12
        //14
        //21
        //22
        StringBuilder sb =  new StringBuilder();
        
        while(n > 0){
            int current = n % 3;
            
            if(current == 0){
                n = (n / 3) - 1;
                sb.insert(0,"4");
            }else if(current == 1){
                n /= 3;
                sb.insert(0,"1");
            }else{
                n /= 3;
                sb.insert(0,"2");
            }

        }
        
        
       
        return sb.toString();
    }
}