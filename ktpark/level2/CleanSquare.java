package level2;

// 멀쩡한 사각형
public class CleanSquare {

	public static void main(String[] args) {
		long ret;
		try {
			ret = solution(8, 12);
			System.err.println(ret);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static long solution(long w, long h) {
        
        long gcd = GCD(w, h);

       return w * h - (w + h - gcd);
   }
   
	public static long GCD(long a, long b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}

}
