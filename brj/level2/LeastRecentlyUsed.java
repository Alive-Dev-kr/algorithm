package level2;

import java.util.LinkedList;
import java.util.Queue;

public class LeastRecentlyUsed {

    /**
     * 접근 방법
     * 1. 캐시(Queue) 내에 city가 존재하는지 확인.
     * 2. 존재할 경우 기존 것 삭제 후 맨 뒤에 재삽입. && 실행시간 +1
     * 3. 존재하지 않을 경우 가장 오래 사용하지 않은(queue의 첫번째) 값을 삭제 후 삽입. && 실행시간 +5
     *
     * 주의 사항
     * 1. 캐시가 0일 때와 0이상일 때 구분
     * 2. 대소문자 구분 없음
     */
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize > 0) {
            String city = null;
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < cities.length; i++) {
                city = cities[i].toLowerCase();

                if (queue.contains(city)) {
                    if (queue.size() == cacheSize) queue.remove(city);
                    answer += 1;
                } else {
                    if (queue.size() == cacheSize) queue.remove();
                    answer += 5;
                }
                queue.offer(city);
            }
        } else {
            answer = 5*cities.length;
        }

        return answer;
    }

    public static void main (String args[]) {
        /*int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};*/
        /*int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};*/
        /*int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};*/
        /*int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};*/
        int cacheSize = 6;
        String[] cities = {"Jeju", "Pangyo", "SanFrancisco", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        solution(cacheSize, cities);
    }
}
