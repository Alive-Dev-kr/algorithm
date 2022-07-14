package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuCombi {

    private static void makeCombination(int r,int[] arr, int[] temp, int current, int start) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(r, arr, temp, current + 1, i + 1);
            }
        }
        Common.println("temp", temp);
    }

    public static void combination() {

    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };

        makeCombination(2, arr, new int[1], 0, 0);
    }

}
