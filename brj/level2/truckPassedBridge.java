package level2;

import java.util.LinkedList;
import java.util.Queue;

public class truckPassedBridge {
    /**
     * 접근 방법
     * queue에 가능한 만큼 쌓고 +1, 다리 건너고 +1, queue에 또 쌓고 +1.
     * * 다리 건너고, queue에 다시 쌓는 거를 분리하여 각각 +1되는 것에 주의해야 함.
     * * 다리를 건넘(queue에서 빠짐)과 동시에 queue(bridge_length)에 쌓을 수 없음.
     *
     *  bridge_length = 3, weight = 10, truck_weights = [7,4,5,1,3,8,9]
     *  1초       [7]
     *  2초       [7,4]
     *  3초  7    [4]
     *  4초  7    [4,5]
     *  5초  7    [4,5,1]
     *  6초  7,4  [5,1]
     *  7초  7,4  [5,1,3]
     */

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        int curTotal = 0; // 현재 다리 위 총 트럭 무게
        Queue<Integer> queue = new LinkedList<>();

        int poll = 0;
        for(int truck_weight : truck_weights) {
            curTotal += truck_weight;

            while (curTotal > weight) {
                poll = queue.poll();
                curTotal -= poll;
                answer += 1;
            }

            if(queue.size() <= bridge_length) {
                queue.offer(truck_weight);
                answer += 1;
            }

        }

        System.out.println("answer : " + answer);

        return answer;
    }

    public static void main(String args[]) {
        /*int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};*/

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        solution(bridge_length, weight, truck_weights);

    }
}
