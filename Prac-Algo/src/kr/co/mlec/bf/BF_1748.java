package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BF_1748 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		long count=0; // ����
		int a=1; // �ڸ��� 1 ~ 9 => 1�ڸ� , 10 ~ 99 => 2�ڸ� ..... 
		
		for(int i=1; i <= num ; i = i * 10 ) {
			int end= i * 10 - 1 ; //�� �ڸ��� ������ ����, 9 , 99 , 999 , 9999 ......
			if( end > num ) { //������ ���ڰ� �Է¹��������� ũ�ٸ� �Էµ� ���� ������ ���̵ȴ�.
				end = num;
			}
			count = count + (long)(end - i + 1) * a; // ( 9 - 1 + 1 ) ==> ���ʴ� => =< �ϱ� +1�� ������� �׷��� ����������
			// 10 <= x <= 99 �� ������  = > 99 - 10 + 1��
			a++;
		}
		System.out.println(count);
	}
}
