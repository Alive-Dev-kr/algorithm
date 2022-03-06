package level1;

import java.util.Scanner;

// https://programmers.co.kr/learn/courses/30/lessons/12969
// 직사각형 별찍기
public class SquareStar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int callCnt = 0;
        
        // 방법 01
        for (int j=1; j<=b; j++) {
			
        	callCnt++;
        	
			for (int i=1; i<=a; i++) {
				System.out.print("*");
				callCnt++;
			}
			
			System.out.println();
			
		}
        
        System.err.println("Call Cnt 1 : " + callCnt);
        
        callCnt = 0;
        
        // 방법 02!
        String retTxt = "";
        String fixTxt = "";
        
        for (int i=1; i<=a; i++) {
        	fixTxt = fixTxt + "*";
        	callCnt++;
		}

        for (int j=1; j<=b; j++) {
			System.out.println(fixTxt);
			callCnt++;
		}
        
        System.err.println("Call Cnt 2 : " + callCnt);
        
	}

}
