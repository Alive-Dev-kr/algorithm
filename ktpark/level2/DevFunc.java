package level2;

import java.util.ArrayList;

public class DevFunc {
	
	public static void main(String[] args) {
		
		int[] prog = {95, 	90, 	99, 	99, 	80, 	99};
		int[] spds = {1, 	1, 		1, 		1, 		1, 		1};
		
		//int[] prog = {93, 30, 55};
		//int[] spds = {1, 30, 5};
		
		int[] result = solution(prog, spds);
		
		for (int ret : result) {
			System.out.println(ret);
		}
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
    	
    	// 각 원소당 완료일까지 얼마나 걸릴지 계산한 일자 수
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        
        Integer calDay = 0;
        for (int i=0; i<progresses.length; i++) {
        	calDay = getProgDayCnt(progresses[i], speeds[i]);
        	System.out.println("계산 필요 일 수 : " + calDay);
        	arrInt.add(calDay);
        }
        
        // 비교에 이용될 값 추출 (첫번째부터 계산해야 하므로 첫번째 값 세팅)
        int maxDay = arrInt.get(0);
        
        // 답변 배열 초기화
        // 자바 배열은 초기 사이즈를 정해줘야 하기 때문에 초기 사이즈 모르는 상태라 ArrayList 사용
        ArrayList<Integer> retArr = new ArrayList<Integer>();
        retArr.add(0);
        
        for (int i=0; i<arrInt.size(); i++) {
        	
        	if (maxDay >= arrInt.get(i)) {
        		// 최대 일 수보다 처리일 수 작으면 더하기 1
        		retArr.set(retArr.size() - 1, retArr.get(retArr.size() - 1) + 1);
        		// retArr[retArr.length - 1] = retArr[retArr.length - 1] + 1; 과 같음
        	} else {
        		// 배열에 값 추가
        		maxDay = arrInt.get(i);
        		retArr.add(1);
        	}
        	
        }
        
        int[] answer = new int[retArr.size()];
        int size = 0;
        for(int temp : retArr){
        	answer[size++] = temp;

        }

        return answer;
    }
    
    public static int getProgDayCnt(int progRate, int speed) {
        
    	int day = 0;
    	
    	while (progRate < 100) {
    		day++;
    		progRate = progRate + speed;
    	}
    	
        return day;
    }

}
