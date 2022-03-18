package level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Spy {
    /**
     * 접근 방법
     *
     * 1. [["세부", "장비"],["세부", "장비"]] 와 같이 되어 있는 배열을 아래와 같이 장비 별로 정리를 해본다.
     * [1, "a"]  [11, "b"]  [21, "c"]  [31, "d"]
     * [2, "a"]  [12, "b"]  [22, "c"]  [32, "d"]
     * [3, "a"]             [23, "c"]  [33, "d"]
     *                      [24, "c"]
     *
     * 2. 장비 명칭을 key값으로 갖고, 장비 별 개수를 value로 갖는 HashMap에 담는다.
     * 위와 같다고 가정할 때, 각 장비별 개수는 a장비 = 3개 / b장비 = 2개 / c장비 = 4개 / d장비 = 3개 이고, 이를 담은 HashMap값은 아래와 같다.
     * HashMap = {a=3, b=2, c=4, d=3}
     *
     * ** 중요 포인트 ** 장비 별 조합은 아래와 같이 가능함.
        * 1. a,b,c,d 모든 조합
        * 2. 듬성 듬성 중간 건너뛰고 나서의 조합 (예 : a,b,d & a,c,d
        * 3. 줄여가기 (예 : a,b,c,d & a,b,c & a,b
     *
     * spy의 복장이 다를 수 있는 경우의 수 계산 법은 아래와 같다.
     * !!!! 방법1 실패 후 방법2로 수정 / 방법3 공식이 더 간단함(Nill씨가 찾아낸 공식) !!!!
     * ====================================================================================================================
     * 방법 1
         * aXb = answer + answerXc = answer + answerXd (=>이 공식은 a,b,c,d 순차적으로 모든 걸 입었을 경우의 수만 찾아내줌.)
         *     => 3X2 = 6 + 6X4 = 30 + 30X3 = 120
         * 잘 보면 첫 a,b를 곱하고 난 후 수식은 계속 동일하다. answer = answer + answer X 다음 장비 개수
         * 마지막으로 최종 결과값인 120에 각 장비별로 개수를 더해주는 것이다.
         *     => 120 + 3(a) + 2(b) + 4(c) + 3(d) = 132
     * ====================================================================================================================
     * 방법 2
         * answer = 1
         * answer + answerXa = answer + answerXb = answer + answerXc = answer + answerXd
         *     => 1 + 1X3 = 4 + 4X2 = 12 + 12X4 = 60 + 60X3 = 240
         * 잘 보면 수식은 계속 동일하다. answer = answer + answer X 다음 장비 개수

         * 마지막 answer-1 = -1은 모두 안 입는 경우를 빼준 경우.
     * ====================================================================================================================
     * 방법 3
         * answer = 0
         * (a+1) X (b+1) X (c+1) X (d+1) -1
            * -1을 해주는 이유는 모두 안 입는 경우를 뺀 것.
         *     => (3+1) X (2+1) X (4+1) X (3+1) = 240
         * 각 장비별 +1은 각 장비별로 안 입을 경우를 포함해준 것.

         * 마지막 answer-1 = -1은 모두 안 입는 경우를 빼준 경우.
     * ====================================================================================================================
     *
     */
    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> intMap = new HashMap<String, Integer>();
        for(String[] clothe : clothes) {
            if( !intMap.containsKey(clothe[1]) ) {
                intMap.put(clothe[1], 1);
            } else {
                intMap.put(clothe[1], intMap.get(clothe[1]) + 1);
            }
        }
        System.out.println(intMap);
        System.out.println("answer1 : " + answer);
        System.out.println("---------------");

        for(int value : intMap.values()) {
            System.out.print("answer2 : " + answer + " / intValue : " + value);
            answer *= value+1; //== answer += answer * value;
            System.out.println(" / " + answer);
        }

        // 위 for문을 없애고 아래 방법으로도 가능
        /*Iterator<Integer> it = intMap.values().iterator();
        while(it.hasNext()) {
            int value = it.next().intValue();
            System.out.print("answer2 : " + answer + " / intValue : " + value);
            answer *= value+1;
            System.out.println(" / " + answer);
        }*/

        System.out.println("---------------");
        System.out.println("answer3 : " + answer);
        return answer-1;
    }

    public static void main (String args[]) {
        //String[][] a = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        /*String[][] a = {{"yellowhat", "a"},
                        {"bluesunglasses", "b"},
                        {"green_turban", "a"},
                        {"green_turban", "b"},
                        {"green_turban", "c"},
                        {"green_turban", "c"},
                        {"green_turban", "c"},
                        {"green_turban", "a"},
                        {"green_turban", "c"}
        };*/
        String[][] a = {{"1", "a"},
                {"11", "b"},
                {"2", "a"},
                {"12", "b"},
                {"21", "c"},
                {"22", "c"},
                {"23", "c"},
                {"3", "a"},
                {"24", "c"},
                {"22", "d"},
                {"23", "d"},
                {"3", "d"}
        };

        solution(a);
    }
}