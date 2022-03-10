package level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 해시
// Level 2 - 위장
public class Spy {

	public static void main(String[] args) {

		/*
		String[][] clothes1 = {
											{"yellowhat", "headgear"},
											{"green_turban", "headgear"},
											{"bluesunglasses", "eyewear"}
											//{"basic_shirt", "shirt"}
										};

		System.err.println("결과 : " + solution(clothes1));
		 */

		String[][] clothes2 = {
				{"crowmask", "face"},
				{"bluesunglasses", "face"},
				{"smoky_makeup", "face"}
			};

		System.err.println("결과 : " + solution(clothes2));

	}

	// .. 해시라고 해서 hashmap에서 재귀함수 호출하면서 난리쳤는데 결국 수학 규칙만 찾으면 간단해지는 문제다..ㅜㅜ
	// 처음에 곱하기 계산으로 뭐 해보려다가 안될거같아서 접었는데 계속 찾을걸..
	// 앞으로 규칙부터 찾는걸로..
	public static int solution(String[][] clothes) {

		HashMap<String, Integer> retMap = new HashMap<>();

		String clothType = null;

		for (int i=0; i<clothes.length; i++) {

			clothType = clothes[i][1];

			retMap.put(clothType, retMap.get(clothType) == null ? 2 : retMap.get(clothType) + 1);

		}

		Iterator<Map.Entry<String, Integer>> iter = retMap.entrySet().iterator();

		int answer = 1;

		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			answer = answer * entry.getValue();
		}

        return answer -1;

    }

}
