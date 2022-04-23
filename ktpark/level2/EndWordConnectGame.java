package level2;

import java.util.HashMap;

// 끝말잇기
/*
	1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
	마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
	앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
	이전에 등장했던 단어는 사용할 수 없습니다. (이 부분은 해시맵 이용하자)
	한 글자인 단어는 인정되지 않습니다.
 */

public class EndWordConnectGame {

	public static void main(String[] args) {
		
		//String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		//String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		int gamerCnt = 2;
		
		// 이미 사용한 단어 확인 용도
		HashMap<String, Boolean> historyWord = new HashMap<String, Boolean>();
		
		String prevWord = null;
		String currentWord = null;
		
		String firstCharOfCurrentWord;
		String lastCharOfPrevWord;

		int retGamerTurn = 1;
		int retGameBoardTurn = 1;
		
		for (int i=1; i<words.length; i++) {
			
			retGamerTurn++;
			
			// 한 판(사람 수) 경과 시 
			// 게이머 구분을 위한 인덱스 턴 초기화
			// 판 수 + 1
			if (i % gamerCnt == 0) {
				retGamerTurn = 1;
				retGameBoardTurn++;
			}
			
			prevWord = words[i - 1];
			currentWord = words[i];
			
			lastCharOfPrevWord = prevWord.substring(prevWord.length() - 1);
			firstCharOfCurrentWord = currentWord.substring(0, 1);
			
			historyWord.put(prevWord, true);
			
			if (firstCharOfCurrentWord.equals(lastCharOfPrevWord) == false) {
				// 이어 말하기 오류
				break;
			}
			
			if (historyWord.get(currentWord) != null) {
				// 이미 사용 오류
				break;
			}
			
			// 게임 끝날때까지 정상 통과 시 Return
			if (i == words.length - 1) {
				retGamerTurn = 0;
				retGameBoardTurn = 0;
			}
			
		}
		
		int[] answer = {retGamerTurn, retGameBoardTurn};
		System.err.println("Answer : " + answer[0] + " / " + answer[1]);
		
	}

}
