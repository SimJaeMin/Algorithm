package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BF_2309 {
	public static void main(String[] args) {
		//9C2 �� 9���� �����̰� �ƴ� 2����  ã���� �Ǵ°���
		//2�� FOR ������ �ϳ��� ��ü�� ���ϴ� �������
		//2���� ���� �� ���ϰſ��� ������ ���� 100�� �Ǹ� ������ 7���� Ű�� ���� 100�̵Ǵ°Ŵϱ�
		//�����̸� ã��������
		int sum=0;
		Scanner sc= new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			a.add(sc.nextInt());
			sum=sum+a.get(i);
		}
		Collections.sort(a);
		
		for(int i=0;i<9;i++) {
			int one = a.get(i);
			for(int j=i+1;j<9;j++) {
				int two=a.get(j);
				if(sum - one - two ==100) {
					for(int z=0;z<9;z++) {
						if(z!=i && z!=j) {
						System.out.println(a.get(z));
						}
					}
					return;
				}
			}
		}
	}
}
