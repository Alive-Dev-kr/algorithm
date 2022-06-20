package level2;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/87946?language=java
class gameTiredness {
    /**
     * 접근 방법
     *
     * 1. 필요 피로도와 소모 필요도 간의 간격이 큰 것, 같을 경우 필요 피로도가 큰 것부터 정렬
     * 2. 위에서 정렬한 것을 for문 돌리기
     * 3. 현재 피로도 - [i][1](소모 피로도) = x(남은 현재 피로도)
     * 4. x가 [i][0](필요 피로도) 보다 크거나 같으면
     * 4-1. answer += 1;
     * 4-2. 3번 진행
     *
     */
    public static int solution(int k, int[][] dungeons) {
        int answer = 0;

        System.out.println("---------------");
        return answer;
    }

    public static void main (String args[]) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        solution(k, dungeons);
    }
}
