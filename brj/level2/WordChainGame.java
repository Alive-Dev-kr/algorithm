package level2;

import java.util.ArrayList;
import java.util.List;

public class WordChainGame {
    /** 접근 방법
     *
     * 1. 이전 단어 마지막 char과 이번 단어의 처음 char같아야 함.
     * 2. 2글자 이상, 50글자 이하여야 함.
     * 3. 겹치는 게 없어야 함.
     *
     * 1. for문을 돌리면서 Array에 push를 함.
     * 2. push한 Array에 contain하는 지 확인(이미 한 단어인지 확인) & 이전 단어의 char와 비교
     * 3. 2번 조건에 해당 하면 탈락.
     */

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        List<String> wordList = new ArrayList<>();

        String curr = "";
        String prev = words[0];
        wordList.add(prev);

        int currStrLeng = 0;
        for(int i=1; i<words.length; i++) {
            curr = words[i];
            currStrLeng = curr.length(); // 글자수 2이상 50이하를 확인하기 위한 변수
            if( curr.charAt(0) != prev.charAt(prev.length()-1) || wordList.contains(curr) || currStrLeng <= 1 || currStrLeng > 50 ) {
                /* 순번 */
                int idx = i+1;
                int answer0 = idx%n; // 나머지 = 순번(단, 나머지가 0일 경우에 순번은 n과 같음.
                switch (answer0) {
                    case 0:
                        answer[0] = n;
                        break;
                    default:
                        answer[0] = answer0;
                        break;
                }
                /* 차례 */
                answer[1] = (int)Math.ceil( (float)idx/n ); // 몫 = 차례(단, 무조건 올림해야 함.)
                break;
            }

            wordList.add(curr);
            prev = curr;
        }

        System.out.println("answer 0 : " + answer[0]);
        System.out.println("answer 1 : " + answer[1]);

        return answer;
    }

    public static void main (String args[]) {
        /*int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; // [3,3]*/

        /* int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}; // [0,0] */

        /*int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"}; // [1,3]*/

        int n = 4;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "now", "world", "draw", "reference", "estimate", "executive"}; // [1,4]

        solution(n, words);
    }
}
