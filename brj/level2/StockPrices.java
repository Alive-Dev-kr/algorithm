package level2;

import java.util.*;

public class StockPrices {

    /**
     * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
     * 입출력 예 설명
     * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
     * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
     * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
     * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
     * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     */

    public static Integer[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();

        // prices를 queue에 담기
        Queue<Integer> queue = new LinkedList<>();
        for(int price : prices) {
            queue.offer(price);
        }

        Integer curr = queue.poll(); // 첫번째 price
        int next = 0;
        int sec = 0; // 유지되는 시간(초)
        while(queue.size() != 0) {
            sec = 0;
            Integer[] q = queue.toArray(new Integer[0]);
            for(int i=0; i<queue.size(); i++) { // curr 다음 것부터 반복
                next = q[i];
                sec++;
                if(curr > next) break;
            }
            list.add(sec);
            curr = queue.poll(); // 현재 price를 dequeue한 후 다음 price대입.
        }
        list.add(0); // 마지막은 무조건 0초

        Integer[] answer = list.toArray(new Integer[0]);
        return answer;
    }

    public static void main(String args[]) {
        int[] prices = {1, 2, 3, 2, 3};
        //int[] prices = {2, 2, 1, 1, 2, 3, 4, 5, 6, 7, 7}; // 2, 1, 8, 7, 6, 5, 4, 3, 2, 1, 0
        solution(prices);
    }
}
