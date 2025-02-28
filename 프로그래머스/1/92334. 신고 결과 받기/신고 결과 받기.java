import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // id_list의 각 사용자의 인덱스를 저장하는 Map
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // 신고된 유저별 신고 횟수 저장 (중복 신고 방지)
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String rp : report) {
            String[] parts = rp.split(" ");
            String reporter = parts[0]; // 신고자
            String reported = parts[1]; // 신고당한 사람

            // 신고 내역을 Set으로 저장하여 중복 신고 방지
            reportMap.putIfAbsent(reported, new HashSet<>());
            reportMap.get(reported).add(reporter);
        }

        // 정지된 유저 목록 생성
        Set<String> bannedUsers = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            if (entry.getValue().size() >= k) { // k번 이상 신고당한 경우
                bannedUsers.add(entry.getKey());
            }
        }

        // 신고한 사람에게 알림 횟수 증가
        for (String bannedUser : bannedUsers) {
            for (String reporter : reportMap.get(bannedUser)) {
                answer[idIndexMap.get(reporter)]++;
            }
        }

        return answer;
    }
}