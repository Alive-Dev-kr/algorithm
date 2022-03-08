package level1;

// 콜라츠 추측
public class CollatzNumber {

	public static void main(String[] args) {

		/*
			1-1. 입력된 수가 짝수라면 2로 나눕니다.
			1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
			2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
		 */
		System.err.println("결과 2 : " + solution(626331));

	}

    public static int solution(int num) {
    	Integer callCnt = 0;
    	getCallCntCollatz(num, callCnt);
    	return callCnt;
    }

    public static Integer getCallCntCollatz(int num, Integer callCnt) {
    	collatz(num, callCnt);
    	return callCnt;
    }

    public static long collatz(long num, Integer calCnt) {

    	if (num % 2 == 1) {
    		// 홀수
    		num = num * 3 + 1;
    	} else {
    		// 짝수
    		num = num / 2;
    	}

    	calCnt = calCnt + 1;

    	if (num == 1) {
    		return calCnt;
    	} else if (calCnt >= 500) {
    		return -1;
    	} else {
    		return collatz(num, calCnt);
    	}

    }

}
