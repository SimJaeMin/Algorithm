package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_15651 {
	static int a[]; //������ �����ϱ�����
	static StringBuilder sb;
	public static void go(int n, int m, int len,String s) {
		if(m==len) {
			sb.append(s.trim()+ "\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			//a[len]=i; // �ߺ��� ���ڵ� �����ϴϱ� 1 ������ 1���� ��� �� �� ���� �׷��� �տ� ���� �Դ��� üũ�ϴ�
				 		//������ �ʿ����.
			go(n,m,len+1, s + " " +i);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		sb= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		a= new int[m]; // m �ڸ� ������ ��������ϴϱ�
		
		go(n,m,0,""); // ó�� �ڸ����� 0�ڸ�
		System.out.println(sb);
	}
}
