package level2;

import common.Common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
public class MenuRenewal {

    static HashMap<String,Integer> map;
    static int m;
    public static String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i=0;i<course.length;i++){
            map = new HashMap<>();
            m=0;
            for (int j=0;j<orders.length;j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()){
Common.println("m", m);
Common.println("s key 값", s);
                if (map.get(s)==m&&m>1){ // 2번 이상 주문된 조합 중 가장 인기있는(m) 조합을 찾기 위함.
                    pq.offer(s);
                }
            }
        }

Common.println("pq", pq);

        String ans[] = new String[pq.size()];
        int k=0;
        while (!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }

    static void find(int cnt,String str,int targetNum,int idx,String word){
Common.println("str", str);

        if (cnt==targetNum){

Common.printlnDash();
Object[][] obj = { {"cnt", cnt}, {"targetNum", targetNum} };
Common.println(obj);

            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for (int i=0;i<c.length;i++)temps+=c[i];
            map.put(temps,map.getOrDefault(temps,0)+1);
            m = Math.max(m,map.get(temps));
            // ?? 이건 왜 안 되지????
            /*map.put(str,map.getOrDefault(str,0)+1);
            m = Math.max(m,map.get(str));*/

Object[][] obj2 = { {"map", map}, {"m", m} };
Common.println(obj2);
Common.println();
            return;
        }
        for (int i=idx;i<word.length();i++){
            char now =word.charAt(i);
            find(cnt+1,str+now,targetNum,i+1,word); // i+1을 함으로써 str+now는 이전 문자열+현재 문자가 더해지는 것임.
        }
    }

    public static void main(String args[]) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        /*String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};*/

        solution(orders, course);
    }
}
