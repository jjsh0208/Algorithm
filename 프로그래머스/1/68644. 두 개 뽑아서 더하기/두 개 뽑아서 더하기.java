import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        // TreeSet으로 add 하면서 정렬
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        //int[] 배열로 반환해야하기에 mapToInt로 int 타입으로 변환후 배열 반환
        return set.stream().mapToInt(i -> i).toArray();
    }
}
