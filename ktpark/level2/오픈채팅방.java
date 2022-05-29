package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

	public static void main(String[] args) {

		
		String[] pRecord = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" } ;
		String[] ans = solution(pRecord);
		
		for (String temp : ans) {
			System.err.println(temp);
		}
		
		// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
	}

	public static String[] solution(String[] record) {
		
        String[] command = null;
        
        List<String> answerArrLst = new ArrayList<String>();
        Map<String, String> userMap = new HashMap<String, String>();
        
        String inputMsg = null;
        String userId = null;
        String userName = null;
        
        // 1. 출력 배열 생성
        // 2. 유저 데이터 저장
        for (int i=0; i<record.length; i++) {
        	
        	command = record[i].split(" ");

        	inputMsg = command[0]; 
        	userId = command[1]; 
        	
        	if ("Change".equals(inputMsg)) {
        		userName = command[2];
        		userMap.put(userId, userName);
        	} else if ("Enter".equals(inputMsg)) {
        		userName = command[2];
        		userMap.put(userId, userName);
        		answerArrLst.add(inputMsg + " " + userId); // Enter kma7456
        	} else if ("Leave".equals(inputMsg)) {
        		answerArrLst.add(inputMsg + " " + userId); // Leave kma7456
        	}
        	
        }
        
        // 3. 리턴할 최종 출력 배열
        String[] answer = new String[answerArrLst.size()];
        
        for (int i=0; i<answerArrLst.size(); i++) {
        	
        	// Leave kma7456
        	command = answerArrLst.get(i).split(" ");
        	
        	inputMsg = command[0]; 
        	userId = command[1]; 
        	userName = userMap.get(userId); // 제일 나중에 들어간 유저 이름이 들어가있다.
        	
        	if ("Enter".equals(inputMsg)) {
        		answer[i] = userName + "님이 들어왔습니다.";
        	} else {
        		answer[i] = userName + "님이 나갔습니다.";
        	}
        	
        }
        
        return answer;
        
    }
    
}
