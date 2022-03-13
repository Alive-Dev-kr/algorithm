package level2;

class MatrixMuletiplication {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // hint 행렬의 곱셈은 arr1의 열과 arr2의 행이 같을 때만 성립됨. = arr1의 열과 arr2의 행 length가 같음.
        int[][] answer = new int[arr1.length][arr2[0].length];

        if(arr1[0].length == arr2.length) {
            for(int ansIdx=0; ansIdx<answer.length; ansIdx++) {
                for(int ansIdx2=0; ansIdx2<answer[0].length; ansIdx2++) {
                    for(int arr2Idx=0; arr2Idx<arr2.length; arr2Idx++) {
                        answer[ansIdx][ansIdx2] += arr1[ansIdx][arr2Idx]*arr2[arr2Idx][ansIdx2];
                    }

                }
            }
        }

        for (int[] ans1 : answer){
            for (int ans : ans1) {
                System.out.print("" + ans + " | ");
            }
            System.out.println("");
        }

        return answer;
    }

    public static void main(String args[]) {
        /*int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};*/

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        /*int[][] arr1 = {{2, 6, 3}, {4, 3, 1}};
        int[][] arr2 = {{9}, {2}, {4}};*/

        solution(arr1, 	arr2);
    }
}