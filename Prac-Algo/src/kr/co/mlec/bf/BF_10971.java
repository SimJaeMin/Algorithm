package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_10971 {
	static int a[][];
	static boolean check[];
	static int min = 0;

	public static void go(int n, int start1, int start, int sum , int index) { // n ��� �̵����� ���� index�� ���ؼ� ������ ��� �������� �湮��
			if(n == index) { // �׶��� �ּҰ��� ������
				if(sum<min || min == 0 ) {
					min=sum;
				}
				return;
			}
			// start1 �� �� ó�� ������ �������� ���� �湮���°� �ƴϰ� �������� �湮�ؾ���
			// �׷��� �� ó�� ������ �������� �����ϰ� �ֱ����� ����
			
			//start �� �� ���� ��°
			//���� ��� 1�������� 2��° �������� ������ start�� 2�� �ǰ� 2���� �ٸ� ������(1,3,4) �� �����ִ��� ( 0 ���� �ƴ��� �Ǵ��ϱ����� �Ѱ���)
			for(int j=0;j<n;j++) {
				if(check[j] == true || a[start][j] == 0) { // �湮�߰ų� , �湮���� ���ϴ� ���̶�� ���� ���
					continue;
				} 
				
				if(j==start1) { // ���� ù��° ���� ��Ҹ� �������ϴµ� 
					if(index+1!=n) { //�װ� �������� �ƴ϶�� �湮 ���Ѵ�.
						continue;
					}
				}
				
				check[j]=true; //�湮�Ѱ��� true�� üũ
				go(n,start1,j,sum+a[start][j],index+1); // j�� �Ѱ��ִ°� ���� �湮�� ���ÿ�
				check[j]=false;
			}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		a = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) { // 1������ ������ ���� �ְ� 2������ ���� 3������ ������ ���� �־ for ���� ���
			go(n,i, i, 0, 0); 
		}
		System.out.println(min);
	}
}
