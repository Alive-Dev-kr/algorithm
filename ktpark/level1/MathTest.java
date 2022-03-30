package level1;

import java.util.ArrayList;
import java.util.List;

// Level 01 : 수포자 - 모의고사 - 찍기문제
public class MathTest {

	public static void main(String[] args) {

		//int[] que = {1,2,3,4,5};
		int[] que = {1,3,2,4,2};

		//int[] que = {1,2,3,4,5};

		int[] ans = solution(que);

		for (int ansVal : ans) {
			System.err.println("Result : " + ansVal);
		}
	}

	public static int[] solution(int[] answers) {

		int[] x = {1, 2, 3, 4, 5};
        int[] y = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] z = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int answerLength = answers.length;
        int[] result = new int[3];

        for (int i=0; i<answerLength; i++) {

        	System.out.println(i + " % " + x.length + " == " + i % x.length);

        	if (x[i % x.length] == answers[i]) {
        		result[0] = result[0] + 1;
        	}

        	if (y[i % y.length] == answers[i]) {
        		result[1] = result[1] + 1;
        	}

        	if (z[i % z.length] == answers[i]) {
        		result[2] = result[2] + 1;
        	}

        }

        int maxScore = Math.max(result[0], Math.max(result[1], result[2]));

        List<Integer> answerArr = new ArrayList<Integer>();

        for (int i=0; i<=2; i++) {
        	if (maxScore <= result[i]) {
        		answerArr.add(i + 1);
        	}
        }

        int[] array = new int[answerArr.size()];
        int size=0;
        for(int temp : answerArr){
          array[size++] = temp;
        }

        return array;

    }

}
