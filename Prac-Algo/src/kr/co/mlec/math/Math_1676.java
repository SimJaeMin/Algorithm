package kr.co.mlec.math;

import java.util.Scanner;

//������ ���丮�� 0�� ����
public class Math_1676 {
	public static void main(String[] args) {
		//���丮�� ���� 0�� ������ �������� 2�� 5�� � ���������� �߿�
		//2*5 =10 �� �Ǳ� ���� 2���� 5�� ���Գ����⶧���� 5�� ������ �˾ƾ���
		//���μ� ���� ������ 2�� 5�� ������
		//5���� �����ÿ��� 0�̾���
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int cnt=0;
		for(int i=5;i<=num;i=i*5) {
			cnt=cnt+num/i;
		}
		System.out.println(cnt);
	}
}
