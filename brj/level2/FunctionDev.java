package level2;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDev {
    /** 접근 방법
     *
     * 1. 남은 완료 일자 = ( 100(100%완성율) - 진행율(progresses) ) / 진행 속도(speed)
     * 2. 남은 완료 일자를 담는 list 생성
     * 3. 남은 완료 일짜가 가장 큰 이전 작업과 현재 작업의 남은 완료 일짜를 비교한다.
     */

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>(); // 정답을 담을 list
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            queue.offer( (int)Math.ceil((double) (100 - progresses[i]) / speeds[i]) );
        }
        System.out.println("queue : " + queue);

        int idx = 0;
        int prev = queue.poll(); // 처음 것을 prev에 대입 후 dequeue(삭제)시킴.
        list.add(1);

        for(Integer a : queue) { // 처음 것을 삭제 했기 때문에 두 번째 것부터 반복
            if(prev >= a) {
                list.set(idx, list.get(idx) + 1);
            } else {
                prev = a;
                idx++;
                list.add(1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println("answer : " + answer[i]);
        }

        return answer;
    }

    public static void main (String args[]) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        /*int[] progresses = {93, 30, 55, 60, 10, 60};
        int[] speeds = {1, 30, 5, 40, 50, 10};*/
        /* 7 3 9 1 2 4
        * 2 4 */

        /*int[] progresses = {93, 97, 95, 91, 99, 98, 96};
        int[] speeds = {1, 1, 1, 1, 1, 1, 1};*/
        /*7 3 5 9 1 2 4*/

        /*int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};*/
        /*5 10 1 1 20 1;
        1 3 2*/

        solution(progresses, speeds);
    }
}
