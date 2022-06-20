package level2;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

//https://programmers.co.kr/learn/courses/30/lessons/87946?language=java
public class tiredness {

    /**
     * 접근 방법
     * 1. 필요 피로도와 소모 피로도 간격이 제일 큰 순서대로 정렬, 만약 간격이 같을 경우 필요 피로도가 큰 수가 먼저 정렬되도록 한다.
     * 2. 현재 피로도가 필요 피로도 이상 또는 같으면,
     * 2-1. 현재 피로도 - 소모피로도 = 현재 남은 피로도 (??? 이게 -너스가 되도 answer += 1; 시키는 건가??)
     * 2-2. answer += 1;
     *
     * 3. 2번을 반복한다.
     */

    public static int solution(int k, int[][] dungeons) {
        int answer = 0;

        SortedSet<Dungeon> sortedSet = new TreeSet<Dungeon>();
        Dungeon dun = null;
        Dungeon dunPrev = null;
        int index = 0;
        for(int[] dungeon : dungeons) {
            dun = new Dungeon(dungeon[0], dungeon[1]);
            sortedSet.add(dun);
            System.out.println(index + " : dun == dunPrev : " + (dun.equals(dunPrev)) );
            dunPrev = dun;
            index++;
        }
        System.out.println("size : " + sortedSet.size());
        Iterator<Dungeon> iter2 = sortedSet.iterator();

        Dungeon curr = null;
        while (iter2.hasNext()) {
            curr = iter2.next();

            if(curr != null) {
                if(k >= curr.getNeed()) {
                    k -= curr.getConsumption();
                    answer += 1;
                }

            }
            System.out.println("need : " + curr.getNeed() + " / consum : " + curr.getConsumption());
        }

        System.out.println(answer);
        return answer;
    }

    public static void main (String args[]) {
        // 3
        /*int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};*/

        //
        /*int k = 120;
        int[][] dungeons = {{80,20},{50,40},{30,10}, {60,10}};*/

        int k = 120;
        int[][] dungeons = {{80,20},{50,40},{30,10}, {60,10}, {70,20}};
        /*int k = 120;
        int[][] dungeons = {{80,20},{50,40},{30,10}, {60,10}, {60,10}};*/

        solution(k, dungeons);
    }
}

class Dungeon implements Comparable<Dungeon> {

    private final int need;
    private final int consumption;

    Dungeon(int need, int consumption) {
        this.need = need;
        this.consumption = consumption;
    }

    public int getNeed() {
        return this.need;
    }
    public int getConsumption() {
        return this.consumption;
    }

    @Override
    public int compareTo(Dungeon o) {
        int compare = this.need - this.consumption;
        int forCompare = o.getNeed() - o.getConsumption();

        if(compare > forCompare) {
            return -1;
        } else if(compare == forCompare) {
            if(this.need > o.getNeed()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }

        // 비교
        /*if(compare > forCompare) {
            return -1;
        } else if(compare == forCompare) {
            return 0;
        } else {
            return 1;
        }*/

    }
}
