package level1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 해시
// 완주하지 못한 선수
public class Marathon {

	public static void main(String[] args) {

		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		String returnName = solution(participant, completion);

		System.err.println("Result Name : " + returnName);
	}

	public static String solution(String[] participant, String[] completion) {

		String answer = null;
		String name = null;

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		for (int i=0; i<participant.length; i++) {

			name = participant[i].toString();

			if (hashMap.containsKey(name) ) {
				hashMap.put(name, hashMap.get(name) + 1);
			} else {
				hashMap.put(name, 1);
			}

		}

		for (int i=0; i<completion.length; i++) {

			name = completion[i].toString();

			if (hashMap.containsKey(name) ) {
				hashMap.put(name, hashMap.get(name) - 1);
			}

		}

		System.out.println("size :: " + hashMap.size());

		Iterator<Map.Entry<String, Integer>> iter = hashMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if (entry.getValue() != 0) {
				answer = entry.getKey();
			}
		}

		System.out.println("hashTable.entrySet() : " + hashMap.entrySet());

        return answer;

    }

}
