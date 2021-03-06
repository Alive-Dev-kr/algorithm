package level2;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
public class KakaoOpenChat {

    public static String[] solution(String[] record) {
        List<String> result = new ArrayList<>();

        List<String> recodList = Arrays.asList(record);
        Collections.reverse(recodList);

        Map<String, String> userMap = new HashMap<>();
        String[] recodSplt = null;
        String rsltStr = null;
        String split1, split2, nickName  = null; // commant, userId, nickname
        /**
         * 마지막이 Leave일 경우 nickName이 null이기 때문에 이를 처리하기 위한 map
         * key = userId
         * value = result list index
         */
        Map<String, Integer> nullMap = new HashMap<>();
        String replaceNull = null;
        for(String str : recodList) {
            recodSplt = str.split(" ");

            split1 = recodSplt[0];
            split2 = recodSplt[1];

            if (userMap.get(split2) == null && (split1.equals("Change") || split1.equals("Enter"))) {
                userMap.put(split2, recodSplt[2]);
            }

            nickName = userMap.get(split2);
            rsltStr = nickName + "님이 ";
            switch (split1.charAt(0)) {
                case 'E':
                    rsltStr += "들어왔습니다.";
                    result.add(rsltStr);
                    break;
                case 'L':
                    rsltStr += "나갔습니다.";
                    result.add(rsltStr);
                    if(nickName == null) {
                        nullMap.put(split2, result.size()-1);
                    }
                    break;
            }
            if(nullMap.get(split2) != null && userMap.get(split2) != null) {
                replaceNull = result.get(nullMap.get(split2)).replaceAll("null", userMap.get(split2));
                result.set(nullMap.get(split2), replaceNull);
                nullMap.remove(split2);// 해당 if문을 다시 들어오지 않게 하기 위함.
            }
        }

        Collections.reverse(result);
        String[] answer = result.toArray(new String[0]);

        System.out.println("========== answer ==========");
        for(String anw : answer) {
            System.out.println(anw);
        }
        System.out.println("============================");

        return answer;
    }

    public static void main (String args[]) {
        //String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        //String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Change uid4567 Ryan","Enter uid1234 Prodo"};
        //String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Change uid4567 Ryan","Enter uid1234 Prodo", "Enter uid1232 New"};
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Change uid4567 Ryan","Enter uid1234 Prodo", "Enter uid1232 New", "Leave uid4567"};

        solution(record);
    }
}
