package level2;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
public class KakaoOpenChat {

    public static String[] solution(String[] record) {
        List<String> result = new ArrayList<>();

        Map<String, String> userMap = new HashMap<>();
        List<String> recodList = Arrays.asList(record);
        Collections.reverse(recodList);

        String[] recodSplt = null;
        String rsltStr = null;
        String split1, split2, split3  = null; // Sort, userId
        for(String str : recodList) {
            recodSplt = str.split(" ");

            split1 = recodSplt[0];
            split2 = recodSplt[1];
            split3 = recodSplt.length==3 ? recodSplt[2] : "";

            if(split2.length() <= 10 && split3.length() <= 10) {
                if (!userMap.containsKey(split2) && (split1.equals("Change") || split1.equals("Enter"))) {
                    userMap.put(split2, split3);
                }

                rsltStr = userMap.get(split2) + "님이 ";
                switch (split1.charAt(0)) {
                    case 'E':
                        rsltStr += "들어왔습니다.";
                        result.add(rsltStr);
                        break;
                    case 'L':
                        rsltStr += "나갔습니다.";
                        result.add(rsltStr);
                        break;
                }
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
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Change uid4567 Ryan","Enter uid1234 Prodo", "Enter uid1232 New"};

        solution(record);
    }
}