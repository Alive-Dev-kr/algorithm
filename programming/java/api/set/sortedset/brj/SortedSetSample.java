package java.api.set.sortedset.brj;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetSample {

    public static void main (String args[]) {
        int[][] numbers = {{80,20},{50,40},{30,10}, {60,10}, {60,11}};
        SortedSet<Number> set = new TreeSet<>();

        for(int[] number: numbers) {
            Number num = new Number(number[0],number[1]);
            set.add(num);
        }

        //정렬된 값 확인
        Iterator<Number> iter = set.iterator();

        Number num = null;
        while(iter.hasNext()) {
            num = iter.next();
            System.out.println("key : " + num.getKey() + " value : " + num.getValue());
        }
    }

}

class Number implements Comparable<Number> {
    private final int key;
    private final int value;

    Number(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Number o) {
        // 오름차순
        if(this.key > o.getKey()) {
            return 1;
        } else if (this.key == o.getKey()) {
            return 0; // 중복 저장 원할 경우 0이 아닌 -1로 수정
        } else {
            return -1;
        }
    }

}
