package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_9095 {
	static int count=0;
	public static void go(int n, int sum) { // n �� �Է¹��� ��, sum �� ���ݱ��� ���� ��
		
		if(sum==n) { // sum �� n �̸�
			count++; // n �� ����� �ִ� 1,2,3 ���ϱⰡ �ִ°Ŵϱ� �ϳ� ����
			return;  // ���⼭ �� �Լ��� ��
		}
		if(sum>n) { // sum�� Ŀ�������� �ǹ̾����ϱ� return 
			return;
		}
		go(n,sum+1); // 1,2,3 ���ϱ�ϱ� 1,2,3 �� �ϳ��� �����ؾ���, 1�� �����Ѱ��
		go(n,sum+2); // 2�� ����
		go(n,sum+3); //3 ������
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		
		for(int i=0;i<t;i++) {
			int n= sc.nextInt();
			
			go(n,0); 
			System.out.println(count);
			count=0;
		}
	}
}
