package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuCombi {

    public static void permutation(int count, Integer[] numbers, String str) {
        List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        List<String> result = new ArrayList<>();

        String tmpStr = "";
        for(int i=0; i<list.size(); i++) {
            tmpStr = str;
            str += list.get(i);

            Integer[] tmpNumbers = list.toArray(new Integer[0]);
            list.remove(i);

            result.add(str);
            permutation(count, tmpNumbers, tmpStr);
        }

        for(String st : result) {
            Common.println("st", st);
        }
    }

    public static void combination() {

    }

    public static void main(String args[]) {
        Integer[] numbers = {3, 2, 1, 5};

        permutation(2, numbers, "");
    }

}
