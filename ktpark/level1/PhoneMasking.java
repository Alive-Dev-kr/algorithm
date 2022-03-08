package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 핸드폰 번호 가리기
public class PhoneMasking {

	public static void main(String[] args) {

		String phoneNumber = "01033334444";
		phoneNumber = "027778888";

		String retStr = solution(phoneNumber);

		System.err.println("Result : " + retStr);
	}

	public static String solution(String phoneNumber) {

		String answer = "";

		for (int i=0; i<=phoneNumber.length() - 5; i++) {
			answer += "*";
		}

		answer += phoneNumber.substring(phoneNumber.length() - 4);

        return answer;

    }

}
