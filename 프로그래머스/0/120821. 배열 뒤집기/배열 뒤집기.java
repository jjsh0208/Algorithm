import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;


//boxed : int를 Integer 로 변환
//collect : 박싱된 요소들을 리스트로 수집

//list.stream(): 리스트를 스트림으로 변환
//.mapToInt(Integer::intValue): 각 요소를 Integer에서 int로 다시 매핑 (언박싱)
//.toArray(): 스트림의 요소들을 int 배열로 변환하여 반환
//list.stream(): 리스트를 스트림으로 변환
class Solution {
    public int[] solution(int[] num_list) {
                
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
      
        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}