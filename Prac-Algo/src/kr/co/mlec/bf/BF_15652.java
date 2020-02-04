package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BF_15652 {
	static StringBuilder sb;
	static int a[];
	public static void go(int n, int m,int len, String s) {
		if(len-1==m) { // len �� 1���� ���������ϱ� len - 1 �� m �� ���� ���� ����Ѵ�.
			//sb.append(s.trim() + "\n");
			for(int i=0;i<m;i++) {
				System.out.print( a[i+1] + " "); // index 1�� index 0 �̴ϱ� +1 ���ش�.
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			
			if(i>=a[len-1]) { // �ڱ� �ٷ� �� index �� ���� ���ؼ� ũ�ų� ���� ���� �ü������ϰ� 
				a[len]=i; 
				go(n,m,len+1,"");
			}
		
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		sb = new StringBuilder();
		a = new int[m+1]; // m+1 �� �迭 ũ�� �����ϴ� ������ index�� 1���� ����ϱ� ���ؼ� 
					      // index -1 �� ���ؼ� �� ������ ū ���� �� �� �ִµ� 0 ���� �����ϸ� index �� -1 �� �ǹ�����.
						  // �̰� ��������  + 1 �� ���ش��� index�� 1�� 0 ó�� ����Ѵ�.
		go(n,m,1 ,""); // len �� 1�� �Ѱ��ش�.
		System.out.println(sb);
		
	}
}
