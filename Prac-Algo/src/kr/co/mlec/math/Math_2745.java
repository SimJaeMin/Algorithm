package kr.co.mlec.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//���� ��ȯ
public class Math_2745 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		String num=s[0];
		int b=Integer.parseInt(s[1]);
		int sum=0;
		int size=num.length();
		
		for(int i=0;i<size;i++) {
			char c=num.charAt(i);
			
			if(c>='A' && c<='Z') {
				sum=sum*b+(int)(c-55); // �Ǿ��� ���ڴ� b�� n���� ����ߵǴϱ� size ��ŭ �ö� b�� �Լ� �����ش�.
			}else {
				sum=sum*b+(int)(c-'0'); //���ڸ� ���ڷ� ������� -'0' ���ڷ� �ҷ��� + '0' 0~9 ��
			}
		}
		System.out.println(sum);
	}
}
