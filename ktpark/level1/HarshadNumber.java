package level1;

// 하샤드 수
// 다른 풀이를 보니 굳이 연속적으로 나누기 10하여 계산하지 않고 String 배열로 나누어 한자리씩 더하는 로직이 있던데 그 알고리즘이 더 간결해보임
public class HarshadNumber {

	public static void main(String[] args) {

		int x = 1400;

		System.err.println("Result : " + solution(x));
	}

	public static Boolean solution(int x) {

		Boolean isAnswer = false;

		if (x < 10) {
			return true;
		}

		int temp = x;
		int val = 0;

		while (temp >= 10) {
			val = val + temp % 10;
			temp = temp / 10;
		}

		val = val + temp;

		if (x % val == 0) {
			isAnswer = true;
		}

		return isAnswer;

    }

}
