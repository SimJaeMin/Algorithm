package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

  class te {
	  int x;
	  int y;
}

public class BF_10972 {
	static int a[];

	public static boolean go(int n) {
		te min = new te(); // ���� index�� ���ÿ� �����ϱ�����
		min.x=n+1; // �ּҰ��� ���ؾ��ϴϱ� �ִ밪�� n+1 ���� ����
		for(int i=n;i>1;i--) { // �ڿ��� ���� �ϳ��� ���ϴµ�
			
			if(a[i] <a[i-1]) { // �ڿ��� ũ�� �ѱ� �׷��� �װ� 
				if(i==2) { // ������ �������� �������� ���°Ŵϱ� false�� ����
					return false; // ����
				}else {
					continue; // �ƴ� ���� ��� ��
				}
			}else { // ó������ ���� �ε����� �� ������ ������
				int temp=a[i-1]; // �� �� �ε����� i- 1 �� ���ʰŴϱ�
								 //�� ���� �����ϰ�
				for(int j=i;j<=n;j++) {  // ó������ ���� �ε������� �۰� ���� ���� ������ ���縦�ؼ� ���� 
					if(min.x>a[j] && a[j] > temp) { // ���� ������ �ε� ���� �ε������� ū ���� ���
						min.x=a[j]; // ���������ϰ�
						min.y=j; // ���� index�� ����
					}	
				}
				a[i-1]=min.x; // ��ġ�ٲٰ�
				a[min.y]=temp; //��ġ�ٲٰ� 
				Arrays.sort(a,i,n+1); // �� �ڿ��� ??? ���� ���ο� ������ �����̴ϱ� ������������ �ٲ��ش�.
				return true;
			}
	}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		if (go(n)) {
			for(int i=1;i<=n;i++) {
				System.out.print(a[i] + " ");
			}
			return; // ������ ��
		}
		System.out.println(-1); // �ȳ����� �����Ŵϱ� -1 
	}
}