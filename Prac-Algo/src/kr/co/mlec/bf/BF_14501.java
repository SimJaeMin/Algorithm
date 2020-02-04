package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_14501 {
	static int data[];
	static int day[];
	static int max=0;
	public static void go(int n, int index, int sum, int len) {
		if(len== n) {
			if(max<sum) {
				max=sum;
			}
			return;
		}
		if(len>n) { // ��糯¥���� ����� �����³��� �� �ʰԵɼ���
			return;
		}
		
		go(n,index+day[index] , sum+data[index],len+day[index]); //�� �� ������ϸ� ����� �ɸ��� �ð���ŭ �ٸ� ����� ���ϴ� �� ��ŭ �Ѱ��ش�.
		go(n,index+1,sum,len+1); //�׳� ����� ���ϸ� �� �������� ����. len �� 1�����ϴ°� ��������ص� ��¥�� �������ϱ�
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		data=new int[n];
		day=new int[n];
		
		for(int i=0;i<n;i++) {
			day[i]=sc.nextInt();
			data[i]=sc.nextInt();
		}
		
		go(n,0,0,0);
		System.out.println(max);
	}
}
