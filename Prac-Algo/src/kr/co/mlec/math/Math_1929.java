package kr.co.mlec.math;

import java.util.Scanner;

//������ : �Ҽ� ���ϱ� (�ֶ��佺�׳׽��� ü)
public class Math_1929 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int first=sc.nextInt();
		int second=sc.nextInt();
		
		boolean p[]=new boolean[second+1];
		p[0]=p[1]=true;
		for(int i=2;i*i<=second;i++) { // �� �� �� ����� ����� �ִ°Ŵϱ� �����.
			for(int j=2;i*j<=second;j++) { // ũ�Ⱑ �����Ѱͺ��ٴ� �۰� , ����� 1�ΰ͵��� ��� x
				p[i*j]=true;
			}
		}
		
		for(int i=first;i<=second;i++) {
			if(p[i]==false) System.out.println(i); //��Ƴ����͵鸸 ���
		}
		
	}
}
