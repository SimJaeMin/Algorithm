package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//������ : ���̻� �迭
public class String_11656 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s =br.readLine();
		int size=s.length();
		String[] sa = new String[size];
		for(int i=0;i<size;i++) {
			sa[i]=s.substring(i,size);	//i��°���� size ���� �κй��ڿ��� �����Ѵ�.
		}
		Arrays.parallelSort(sa);  //�������ش�
		
		for(int i=0;i<size;i++) {
			System.out.println(sa[i]);
		}
	}
}
