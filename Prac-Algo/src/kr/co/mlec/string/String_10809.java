package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//������ : ���ĺ�ã��
//��ȣ : 10809
public class String_10809 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] check = new int[26];
	for(int i=0;i<26;i++) {
		check[i]=-1; // �ʱ� �迭�� �ƹ��͵� �����ϱ� -1�� ����
	}
	String s= br.readLine();
	int size=s.length();
	for(int i=0;i<size;i++) {
		if(check[s.charAt(i)-'a']==-1) { //-1�̶�°��� ���� �ѹ��� �ȳ��Դٴ°�
			check[s.charAt(i)-'a']=i; // �׋� �� ����  index�� �ٲ��ش�.
		}
	}
	
	for(int i=0;i<26;i++) {
	System.out.print(check[i] + " ");
	}	
	System.out.println();
}
}
