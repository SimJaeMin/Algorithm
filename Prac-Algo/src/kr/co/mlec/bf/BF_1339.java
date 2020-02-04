package kr.co.mlec.bf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BF_1339 {
	static int al[];
	public static void sq(char a, int len) {
		int num=1; 
		for(int i=1;i<len;i++) { //1���� �����ϴ� ������ 1�� �ڸ��� * 10 �� �� �ʿ䰡�����ϱ�
			num=num*10; 
		}
		al[a-'A']=al[a-'A']+num; // �ƽ�Ű�ڵ� ���� �̿��ؼ� ���ָ� �� ���� �ε����� �ǰ� * 10 ���ذ��� �� �ε����� �����ش�.
	}
	public static void rever(int[] a) { // �����������ִ� �迭�� ������������ ��ȯ���ش�.
		int size=a.length-1; //������� 1���ͽ����ϴϱ� 1�� ����� �ε����� ���� �� �� ����
		int size1=size/2; // ����� 2�� ������ŭ��
		for(int i=0;i<size1;i++) {
			int temp=a[i];
			a[i]=a[size-i]; 
			a[size-i]=temp;
		}
	}
	public static void main(String[] args) {
		//BACD , EFGB �̷������� �Է��� ����
		//�̰Ŵ� (1000B + 100A + 10C + D) +  (1000E + 100F + 10G+ B) �̰���
		//�̰Ŵ� (1001B + 1000E + 100A+ 100F+ 10C + 10 G + D )��
		//�̰Ÿ� �׳� �� ū������ 9���� �ϳ��� �����ϸ��
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		String s[] = new String[num];
		al= new int[26]; //�빮�� 26��
		for(int i=0;i<num;i++) 
		{
			s[i]=sc.next(); //���ڿ��Է�
		}		
		
		for(int i=0;i<num;i++) { //�Է¹��� ���ڿ� 1���� N ����
			int len=s[i].length(); // N��° ���ڿ��� ���̸� ������
			for(int j=0;j<s[i].length();j++) { // �� ���ڿ��� 4�ڸ��� 1000, 3�ڸ��� 100 ....
				char a=s[i].charAt(j); // ù���� �ڸ� ���
				sq(a,len); // �׶� �ڸ�����ŭ 10�� ���ؼ�
				len--;
			}
		}
		Arrays.sort(al);
		rever(al);
		int sum=0;
		int aa=9;
		for(int i=0;i<al.length;i++) {
			if(al[i]==0) {
				break;
			}
			sum=sum+al[i]*aa;
			aa--;
		}
		System.out.println(sum);
	}
}
