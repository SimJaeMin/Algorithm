package kr.co.mlec.math;

import java.util.Scanner;

//������ : ���μ�����
public class Math_11653 {
	public static void main(String[] args) {
		//���μ� ���ض� �Ҽ��� ���� ���� ǥ���ϴ°���
		//2���� i*i ���� �ϳ��� ���� �ȳ����������� ��� �������ش�..
		
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=2;i*i<=num;i++) {
			
			while(num%i==0) {
				System.out.println(i);
				num=num/i;
			}
			
		}
		if(num>1) {
			System.out.println(num);
		}
	}
}
