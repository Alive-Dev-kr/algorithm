package level2;

import java.util.HashMap;
import java.util.Map;

public class EatLandSecond {

	public static void main(String[] args) {
		
		int[][] land1 = {
				{1, 1, 1, 1},
				{2, 2, 2, 3},
				{3, 3, 3, 6},
				{4, 4, 4, 7}
			};
		
		int[][] land2 = {
				{1, 2, 3, 5},
				{5, 6, 7, 8},
				{4, 3, 2, 1}
			};
		
		int answer = solution(land2);
		System.err.println("Answer = " + answer);
	}
	
	public static int solution(int[][] land) {
		
		// 결과 배열
		int[] resultArr = new int[4];
		
		// 결과값
		int answer = 0;
		
		// 행 사이즈
        int rowSize = land.length;
        
        // 행 For문 Go
        for (int i=0; i<rowSize; i++) {
        	
        	resultArr = getBestMaxSumArr(resultArr, land[i], i);
        	
        }
        
        // 결과 배열에서 최대값 GET
        answer = resultArr[0];
        for (int i=1; i<resultArr.length; i++) {
        	if (answer < resultArr[i]) {
        		answer = resultArr[i];
        	}
        }
        
        return answer;
    }
	
	public static int[] getBestMaxSumArr(int[] retArr, int[] land, int seq) {
		
		if (seq == 0) {
			retArr[0] = retArr[0] + land[0];
			retArr[1] = retArr[1] + land[1];
			retArr[2] = retArr[2] + land[2];
			retArr[3] = retArr[3] + land[3];
		} else {
			Integer getMaxScoreWithoutIndex1 = getMaxScoreWithoutIndexMap(retArr, 0).get("maxScore");
			Integer getMaxScoreWithoutIndex2 = getMaxScoreWithoutIndexMap(retArr, 1).get("maxScore");
			Integer getMaxScoreWithoutIndex3 = getMaxScoreWithoutIndexMap(retArr, 2).get("maxScore");
			Integer getMaxScoreWithoutIndex4 = getMaxScoreWithoutIndexMap(retArr, 3).get("maxScore");
			
			retArr[0] = land[0] + getMaxScoreWithoutIndex1;
			retArr[1] = land[1] + getMaxScoreWithoutIndex2;
			retArr[2] = land[2] + getMaxScoreWithoutIndex3;
			retArr[3] = land[3] + getMaxScoreWithoutIndex4;
		}
		
		return retArr;
	}
	
	public static Map<String, Integer> getMaxScoreWithoutIndexMap(int[] scoreArr, Integer myIndex) {
		
		Map<String, Integer> maxScoreAndIndex = new HashMap<String, Integer>();
        int score = 0;
        int selIndex = 0;
        
        // 열 For문 Go
        for (int i=0; i<scoreArr.length; i++) {
        	
        	if (myIndex == i) {
        		// 넘어온 인덱스와 같은 인덱스면 비교 안함
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
