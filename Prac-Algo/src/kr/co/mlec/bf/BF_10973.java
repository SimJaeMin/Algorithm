package kr.co.mlec.bf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
class aa {
	int x;
	int y;
	
}
public class BF_10973 {
	static int a[];
	public static boolean go(int n) {
		aa aa = new aa(); //index�� ���� �������ֱ�����
		aa.x=0; 
		for(int i=n ; i>1; i--) { //�ڿ������� ��������ؼ� �����ε����� ó������ �� ���� ���� ���� ������
			
			if(a[i] >  a[i-1]) { // ���� �ε����� ũ�� �ѱ�
				
				if(i==2) { // �ٵ� �װ� �������������� �������� ���°��� 1,2,3,4,5,6 ������ ���� ���� ���簡 ���ŭ 
					return false; // ������ �����ϱ� false ����
				}else {
					continue;
				}
			}else {
				int temp=a[i-1]; // ������ �� ū���� ������ �׶� �������� ����
				
				for(int j=i ; j<=n;j++) { //���� �������� ���� �����ؼ�
					if(aa.x < a[j] && a[j] < a[i-1]) { // ���� �� ���ٴ� ������ �� �� ���� ū ���� ã�Ƴ�
						aa.x=a[j]; // ��
						aa.y=j; // �ε���
					}
				}
				
				a[i-1]=aa.x; // ��ġ��ȯ
				a[aa.y]=temp; // ��ġ��ȯ
				
				for(int z=i;z<=n;z++) { // �ε��� ���� �ٽ� ������������ ����
					for(int zz=z+1;zz<=n;zz++) {
						if(a[z]<a[zz]) {
							int temp1=a[z];
							a[z]=a[zz];
							a[zz]=temp1;
						}
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i]=sc.nextInt();
		}
		
		if(go(n)) {
			for(int i=1;i<=n;i++) {
				System.out.print(a[i] + " ");
			}
			return;
		}
		System.out.println(-1);
	}
}
