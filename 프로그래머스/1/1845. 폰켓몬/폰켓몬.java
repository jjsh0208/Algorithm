import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums){
            set.add(i);
        }
        
        return Math.min(nums.length / 2 , set.size());
    }
}