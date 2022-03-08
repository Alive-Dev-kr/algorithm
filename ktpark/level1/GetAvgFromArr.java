package level1;

// 편균 구하기
public class GetAvgFromArr {

	public static void main(String[] args) {

		//int[] arr1 = { 1, 2, 3, 4 };
		int[] arr1 = { 5, 5 };

		double retAvg = solution(arr1);
		System.err.println("결과 : " + retAvg);


	}

    public static double solution(int[] arr1) {

    	double sum = 0;

    	for (int i=0; i<arr1.length; i++) {
    		sum += arr1[i];
    	}

        return sum / arr1.length;
    }

}
