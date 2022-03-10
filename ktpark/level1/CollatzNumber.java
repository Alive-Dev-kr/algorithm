package level1;

// 콜라츠 추측
public class CollatzNumber {

	public static void main(String[] args) {

		/*
			1-1. 입력된 수가 짝수라면 2로 나눕니다.
			1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
			2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
		 */
		//System.err.println("결과 : " + solution(626331));
		System.err.println("결과 : " + solution(16));

	}

    public static int solution(int num) {

    	int callCnt = 0;

    	while (num != 1) {

    		if (callCnt >= 500) {
    			callCnt = -1;
    			break;
    		}

    		if (num % 2 == 1) {
        		// 홀수
        		num = num * 3 + 1;
        	} else {
        		// 짝수
        		num = num / 2;
        	}

    		callCnt++;

    	}

    	return callCnt;
    }

    public static long collatz2(long num) {

    	/*
    	 * 간단하게 반복문 하나로 해결할 수 있던거를 재귀로 쓰려다가 뻘짓..
    	 * (작동은 한다..)
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
    	 */

    	return 1;

    }

}
