package level1;

// https://programmers.co.kr/learn/courses/30/lessons/12950
// 행렬의 덧셈
public class RowColMatrix_Plus {

	public static void main(String[] args) {
		
		//int[][] arr1 = { {1, 2}, {2, 3} };
		//int[][] arr2 = { {3, 4}, {5, 6} };
		
		//int[][] arr1 = { {1}, {2} };
		//int[][] arr2 = { {3}, {4} };
		
		int[][] arr1 = { 
					  {1, 2, 4}
					, {2, 3, 5} 
				};
		
		int[][] arr2 = { 
					  {3, 4, 6}
					, {4, 4, 5} 
				};
		
		int[][] retArr = solution(arr1, arr2);
		
		System.out.println("Finish");
		
	}
	
    public static int[][] solution(int[][] arr1, int[][] arr2) {
    	
    	//int rowSize = arr1[0].length;
    	int rowSize = arr1.length;
    	int colSize = arr1[1].length;
    	
    	System.err.println("allSize : " + arr1.length);
    	System.err.println("rowSize : " + rowSize);
    	System.err.println("colSize : " + colSize);
    	
        int[][] answerArr = new int[rowSize][colSize];
        
        int val = 0;
        
        for (int i=0; i<rowSize; i++) {
        	
        	for (int j=0; j<colSize; j++) {
        		
        		val = arr1[i][j] + arr2[i][j];
        		
        		System.err.println("val : " + val);
        		
        		answerArr[i][j] = val;
        		
        		
        	}
        	
        }
        
        return answerArr;
    }

}
