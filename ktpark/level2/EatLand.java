package level2;

import java.util.HashMap;
import java.util.Map;

public class EatLand {

	public static void main(String[] args) {
		
		int[][] land = {
				{4,3,2,1},
				{2,2,2,1},
				{6,6,6,4},
				{8,7,6,5}
			};
		
		int answer = solution(land);
		System.err.println("Answer = " + answer);
	}
	
	public static int solution(int[][] land) {
		
        int rowSize = land.length;
        
        Integer prevSelectedIndex = null;
        int answerScore = 0;
        
        Map<String, Integer> maxScoreAndIndex = new HashMap<String, Integer>();
        
        for (int i=0; i<rowSize; i++) {
        	
        	maxScoreAndIndex = getMaxScoreWithoutIndex(land[i], prevSelectedIndex);
        	
        	prevSelectedIndex = maxScoreAndIndex.get("selIndex");
        	answerScore = answerScore + maxScoreAndIndex.get("maxScore");
        }
        
        return answerScore;
    }
	
	public static Map<String, Integer> getMaxScoreWithoutIndex(int[] scoreArr, Integer prevIndex) {
		
		Map<String, Integer> maxScoreAndIndex = new HashMap<String, Integer>();
        int score = 0;
        int selIndex = 0;
        
        for (int i=0; i<scoreArr.length; i++) {
        	
        	if (prevIndex != null && prevIndex == i) {
        		// 선택된 이전 인덱스가 없으면 Pass
        	} else {
        		if (scoreArr[i] >= score) {
        			score = scoreArr[i];
        			selIndex = i;
        		}
        	}
        	
        }
        
        maxScoreAndIndex.put("maxScore", score);
        maxScoreAndIndex.put("selIndex", selIndex);

        return maxScoreAndIndex;
    }

}
 