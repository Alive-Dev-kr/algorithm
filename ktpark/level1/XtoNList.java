package level1;

// https://programmers.co.kr/learn/courses/30/lessons/12954
// x만큼 간격이 있는 n개의 숫자
public class XtoNList {

	public static void main(String[] args) {
		long[] retArr = solution(5, 10);

		//System.err.println(retArr.length);
		for (int i=0; i<retArr.length; i++) {
			System.err.println(retArr[i]);
		}
	}
	
    public static long[] solution(int x, int n) {
    	
        long[] arr = new long[n];
        
        arr[0] = x;
        
        for (int i=1; i<n; i++) {
        	arr[i] = arr[i-1] + x;
        }
        
        return arr;
    }

}
