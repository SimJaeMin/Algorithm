package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15650_2 {
	static int a[];
	public static void go(int n , int m , int len, int index) {
		
		if(len == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+ " ");
			}
			System.out.println();
			return;
		}
		if(index>n) { // ���� ���� ���Ҷ�
			return;
		}
		
		a[len]=index; // �����ϴ� ���
		go(n,m,len+1, index +1);
		a[len]=0; // ���� ���� �ʴ°��
		go(n,m,len,index+1);
		//���� �ڸ������� a[len] ������
	}
	public static void main(String[] args) {
		//���� ������� Ǯ����
		//�׷��� ���� �� �� ������ �������� ������ (���������̸� ���� , �ƴϸ� ���� X ) �� �����������
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int m= sc.nextInt();
		
		a= new int[m];
		
		go(n,m,0,1);
		
	}
}
