package kr.co.mlec.math;
//������ :������
import java.util.Scanner;

public class Math_10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		// (a+b) % c �� ( (a%c) + (b%c) ) % c�� ����.
		// ������� �ش�ȵǰ�
		//���� �汸 a%c - b%c �� -�� �ɼ� ������ �� �ڿ� c�� �����ش�.
		System.out.println((a+b)%c);
		System.out.println( ( (a%c) + (b%c) ) % c) ;
	
		System.out.println((a*b)%c);
		System.out.println( ( (a%c) * (b%c) ) %c);
	}
}
