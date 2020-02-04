package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_6064 {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t>0) {
			int m= sc.nextInt(); // x�� �����ִ� �ִ� �� 
			int n= sc.nextInt(); // y�� �����ִ� �ִ� ��
			int x= sc.nextInt(); // ã����� �� x
			int y= sc.nextInt(); // ã����� �� y
			int num=0; // ���࿡ ã�� ���� ������ 
			x= x-1; // -1 ���ִ� ������ ��ⷯ �������� ã���ǵ� x�� 12, n�� 12�̸� 0�̳��ͼ� 0���� �ذ��ϱ�����
			y= y-1;
			if(m<=n) {
				for(int i=x,j=1 ; j<=n; j++, i=i+m) { // x�� �ִ밪�� ������ x�� �������� y���� ã�������Ѵ�.
						//�� ó�� ����(1~m�� �� �ѹ����� �ȵ� �� ó�� x) x�� �ʱⰪ i�� ����
						// j=1 ��� �ݺ��ؾ����� ���Ҷ� ��ⷯ �����̴ϱ� �ִ� n �� �ȿ� ã�ƾߵȴ�. n��ã�°Ŵϱ�
						// j�� +1 , i�� m ��ŭ �����༭ �� ���������� n�� ã�´�
						if(y== (i%n) ) { //n�� ã�� ���� ó�� i�� n���� �������ָ� ���� ���� y�̸� �װ�, �� ���ķδ� ������ x���� �����̴ϱ�
							// ����ؼ� x�� �ֱ��� m�� �����ְ� �� ���� n���� ������������ ���̶� �����ش�.
							System.out.println(i+1); // 0 ������ -1�� ���־����ϱ� +1�� ���ػ��·� ���
							num=1;
							break;

						}
				}
			}else {
				for(int i=y , j=1 ; j<=m ; j++, i=i+n) {
					if(x== (i%m)) {
						System.out.println(i+1);
						num=1;
						break;
					}
				}
			}
			
			if(num==0) {
				System.out.println(-1);
			}
			t--;
		}
		
		
	}
}
