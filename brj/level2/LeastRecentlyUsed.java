package level2;

import java.util.LinkedList;
import java.util.Queue;

public class LeastRecentlyUsed {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        String city = null;
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            city = cities[i].toLowerCase();

            if( queue.contains(city) ) {
                if(queue.size() == cacheSize) queue.remove(city);
                answer+=1;
            } else {
                if(queue.size() == cacheSize && cacheSize > 0) queue.remove();
                answer+=5;
            }
            if(cacheSize > 0) queue.offer(city);
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
