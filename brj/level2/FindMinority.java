package level2;

import common.Common;

import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/42839
public class FindMinority {

    private static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            System.out.println("a : " + a);
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }

        System.out.println("count : " +count);
        return count;
    }

    public static boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        Common.println("n", n);
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++) {
            Object[][] obj = { {"prefix", prefix}, {'i', i}, {"str.charAt(i)", str.charAt(i)} };
            Common.println(obj);

            Object[][] obj2 = { {"str.substring(0, i)", str.substring(0, i)}, {"substring(i + 1, n)", str.substring(i + 1, n)} };
            Common.println(obj2);
            Common.println();
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
        Common.printlnDash();
    }

    public static void main(String args[]) {
        //String numbers = "17";
        String numbers = "011";
        solution(numbers);

        Common.println("numbers", numbers);
    }
}
