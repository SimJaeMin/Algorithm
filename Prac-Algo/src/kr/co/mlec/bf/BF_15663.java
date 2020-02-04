package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BF_15663 {
	static ArrayList<Integer> a;
	static int check[] = new int[10001];
	static int aa[];
	
	public static void go(int n, int m , int len) {
		if(len==m) {
			for(int i=0;i<m;i++) {
				System.out.print(aa[i] + " " );
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(check[a.get(i)]>0) { // 0���� ū �ɷ� ���� ������ �̹� ����� ���������� �ƴ��� ���ϱ� ���� 
				check[a.get(i)]--; // ���̳ʽ� ���ָ� 1�� �ִ� �����͸� 0�� �ǰ� 2�������� 1 �� �Ǵϱ� �ߺ��� ���ȵ����� �Ѵ� �Ǵ� ����
				aa[len]=a.get(i);
				go(n,m,len+1);
				check[a.get(i)]++;
			}
		}

			
		}
		
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n= Integer.parseInt(s[0]);
		int m= Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		aa = new int[m];
		Set<Integer> set = new TreeSet<Integer>(); // �ߺ��� �����͸� ���ֱ� ���� TreeSet �� ��� TreeSet�� �ڵ����� ������������ ���ĵȴ�.
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(s[i])); // �����͸� Set�� �����鼭 �ߺ��� �������ְ�
			check[Integer.parseInt(s[i])]++; // ���� ���� � �ִ��� üũ���ֱ� ���� int������ 
		}
		a=new ArrayList<Integer>(set); // �ߺ��� ������ set�� �������� ArrayList�� �����.

		go(a.size(),m,0); // ��ͽ���
	}
}
