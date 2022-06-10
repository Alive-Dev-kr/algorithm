import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {

    static Map<String, Integer> cache = new HashMap<>();

    public synchronized static void main(String[] args) {

        int row = 6;
        int col = 6;

        int [][] queries = {
                                        {2,2,5,4},
                                        {3,3,6,6},
                                        {5,1,6,3}
                                    };

        int[] answerArr = solution(row, col, queries);

        for (int result : answerArr) {
            System.err.println("Result : " + result);
        }

    }

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows][columns];

        int x_index = 0;
        int y_index = 0;

        // 2차원 배열 생성
        for (int i=0; i<=(rows * columns) - 1; i++) {

            matrix[y_index][x_index] = i + 1;

            if ((x_index + 1) % columns == 0) {
                // 행 카운트 증가
                y_index++;
                x_index = 0;
            } else {
                // 열 카운트 증가
                x_index++;
            }

        }

        int finalSmallVal = 0;

        for (int i=0; i<queries.length; i++) {
            int[] nowTurnQuery = queries[i];

            int smallValueW = changeMatrixRightAndBottom(matrix, nowTurnQuery);
            int smallValueY = changeMatrixLeftAndTop(matrix, nowTurnQuery);
            finalSmallVal = Math.min(smallValueW, smallValueY);

            answer[i] = finalSmallVal;

            cache.clear();
        }

        return answer;

    }

    private static int changeMatrixRightAndBottom(int[][] matrix, int[] nowQuery) {

        boolean isHorizonEnd = false;
        boolean isVerticalEnd = false;

        int pointerX = nowQuery[1] - 1;
        int pointerY = nowQuery[0] - 1;

        int endPointerX = nowQuery[3] - 1;
        int endPointerY = nowQuery[2] - 1;

        Integer temp1 = null;
        Integer temp2 = null;

        TreeSet<Integer> set = new TreeSet<>();

        while (isHorizonEnd == false || isVerticalEnd == false) {

            if (isHorizonEnd == false) {

                // 가로 진행
                pointerX++;

                // 현재 위치의 값
                temp1 = matrix[pointerY][pointerX];

                // 이전 위치의 값
                temp2 = matrix[pointerY][pointerX - 1];

                set.add(temp1);
                set.add(temp2);

                matrix[pointerY][pointerX] = cache.get("nextVal") != null ? cache.get("nextVal") : temp2;

                cache.put("nextVal", temp1);

                if (pointerX == endPointerX) {
                    isHorizonEnd = true;
                }

            } else {

                // 세로 진행
                pointerY++;

                temp1 = matrix[pointerY][pointerX];

                temp2 = matrix[pointerY - 1][pointerX];

                set.add(temp1);
                set.add(temp2);

                matrix[pointerY][pointerX] = cache.get("nextVal") != null ? cache.get("nextVal") : temp2;

                cache.put("nextVal", temp1);

                if (pointerY == endPointerY) {
                    isVerticalEnd = true;
                }

            }

        }

        int answer = set.first();

       return answer;

    }

    private static int changeMatrixLeftAndTop(int[][] matrix, int[] nowQuery) {

        boolean isHorizonEnd = false;
        boolean isVerticalEnd = false;

        int pointerX = nowQuery[3] - 1;
        int pointerY = nowQuery[2] - 1;

        int endPointerX = nowQuery[1] - 1;
        int endPointerY = nowQuery[0] - 1;

        Integer temp1 = null;
        Integer temp2 = null;

        TreeSet<Integer> set = new TreeSet<>();

        while (isHorizonEnd == false || isVerticalEnd == false) {

            if (isHorizonEnd == false) {

                // 가로 진행
                pointerX--;

                // 현재 위치의 값
                temp1 = matrix[pointerY][pointerX];

                // 이전 위치의 값
                temp2 = matrix[pointerY][pointerX + 1];

                set.add(temp1);
                set.add(temp2);

                matrix[pointerY][pointerX] = cache.get("nextVal") != null ? cache.get("nextVal") : temp2;

                cache.put("nextVal", temp1);

                if (pointerX == endPointerX) {
                    isHorizonEnd = true;
                }

            } else {

                // 세로 진행
                pointerY--;

                temp1 = matrix[pointerY][pointerX];

                temp2 = matrix[pointerY + 1][pointerX];

                set.add(temp1);
                set.add(temp2);

                matrix[pointerY][pointerX] = cache.get("nextVal") != null ? cache.get("nextVal") : temp2;

                cache.put("nextVal", temp1);

                if (pointerY == endPointerY) {
                    isVerticalEnd = true;
                }

            }

        }

        int answer = set.first();

        return answer;

    }

}