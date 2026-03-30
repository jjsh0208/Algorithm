class Solution {
    public int solution(int[] numbers, int target) {

        return DFS(numbers,target,0,0);
    }
    
    private static int DFS(int[] numbers, int target, int index, int sum){
        if(numbers.length == index){
            if(sum == target){
                return 1;
            }
            else return 0;
        }
        
        return DFS(numbers,target, index + 1, sum + numbers[index]) +
            DFS(numbers,target, index + 1, sum - numbers[index]);
    }
}