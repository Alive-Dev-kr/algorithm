package level2;

//https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
public class Printer {

    public static int solution(int[] priorities, int location) {
        int need = priorities[location];
        boolean check = false;
        // answer가 1인 이유는 본인 포함하여 무조건 1이상이기 때문에
        int curr, answer = 1;

        for(int i=0; i<priorities.length; i++) {
            curr = priorities[i];
            if(location != i) {
                if(need < curr) {
                    answer++;
                    if (location < i) {
                        check = true;
                    }
                } else if ( need == curr && i < location) {
                    // location보다 앞에 위치한 같은 중요도
                    answer++;
                } else if ( need == curr && location < i && check) {
                    // location보다 뒤에 위치한 같은 중요도 => location보다 뒤에 높은 중요도가 존재할 경우에만 answer에 더해줌.
                    answer++;
                }
            }// location이 아닐 때
        }

        System.out.println(answer);

        return answer;
    }

    public static void main (String args[]) {
        // 1
        /*int[] priorities = {2, 1, 3, 2};
        int location = 2;*/
        // 5
        /*int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;*/
        // 6
        /*int[] priorities = {2, 1, 9, 1, 1, 1};
        int location = 1;*/
        // 2
        /*int[] priorities = {1, 2, 9, 1, 1, 1};
        int location = 1;*/
        // 8
        /*int[] priorities = {1,1,1,1,2,1,1,1,1};
        int location = 2;*/
        // 5
        /*int[] priorities = {1,1,1,1,1};
        int location = 4;*/

        /*int[] priorities = {1,2,3,4,5,6,7,8,9};
        int location = 1;*/
        int[] priorities = {1, 1, 9, 1, 2, 6, 1};
        int location = 1;

        solution(priorities, location);
    }
}
