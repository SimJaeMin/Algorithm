package kr.co.mlec.math;

import java.util.Scanner;

//�Ҽ� ã��
public class Math_1978 {
	//�Ҽ��� ã�� �� n/2 ���� ã�� ������ n�� ����� 2���� ������ �����ϱ� �۰ų� ���⶧��
	//n�� ���� ���ִ� ���� ���� ū ���� ?*? =n �� �� 2�� �Ҷ� ���� ���� ���� Ŀ���� ������ n/2���� �������
	//
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		
		int arr[] =new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		int cnt=0;
		for(int i=0;i<num;i++) {
			if(arr[i]<2) {
				continue;
			}
			for(int j=2;j*j<=arr[i];j++) {
				if(arr[i]%j==0) {
					break;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
