package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15650 {
	//NM (1) �� ������ ������ ���� �����ΰŸ� ���������Ѵ�.
	static int a[];
	static boolean check[];
	
	public static void go(int n , int m ,int len , int num ) { // num�� ���������� �Ǵ� ������ �������ϱ� ������
															   // ���� index - 1 �� ���� �Ѱ��־ �� ������ ū ���� üũ �ϰ� ���� ������ �� �ְ� ���ֱ� ���� ����
		if(m==len) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) { // 1 ���� n ���� 
			
			if(check[i]) {
				continue;
			}
						
			if(num<i) { //���������� ������� num ( ���� index -1 �� �� )���� ū ���� ���� ������ �����ؾ��ϱ� ������ �����ش�.
				check[i]=true;
				a[len]=i;
				go(n,m, len+1,i);
				check[i]=false;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		check = new boolean[n+1];
		a= new int[m];
		
		go(n,m,0,0);
		
		
	}
}
