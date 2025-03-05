class Solution {
    public int[] solution(String s) {
        
        // 0 index : 1이 될 때 까지 이진 변환 과정 수
        // 1 index : 총 제거한 0의 수
        int[] answer = {0,0};
        
        while (!s.equals("1")) { // s가 "1"이 될 때까지 반복
            int zeroCount = s.length() - s.replaceAll("0", "").length(); // 제거할 0의 개수
            answer[1] += zeroCount; // 총 제거한 0의 개수 누적

            s = s.replaceAll("0", ""); // 0 제거
            s = Integer.toBinaryString(s.length()); // 남은 길이를 2진수 변환

            answer[0]++; // 변환 횟수 증가
        }
        
        
        return answer;
    }
}