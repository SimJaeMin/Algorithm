package kr.co.mlec.math;
//문제명 :나머지
import java.util.Scanner;

public class Math_10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		// (a+b) % c 와 ( (a%c) + (b%c) ) % c는 같다.
		// 나누기는 해당안되고
		//뺄셈 경구 a%c - b%c 가 -가 될수 있으니 그 뒤에 c를 더해준다.
		System.out.println((a+b)%c);
		System.out.println( ( (a%c) + (b%c) ) % c) ;
	
		System.out.println((a*b)%c);
		System.out.println( ( (a%c) * (b%c) ) %c);
	}
}
