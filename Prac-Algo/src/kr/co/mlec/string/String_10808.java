package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� �̸� :���ĺ� ����

//���� ��ȣ : 10808 
public class String_10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine(); //�ʱ⿡ ������ �Է¹޴´�.
		int[] check=new int[26]; // ������ ���� �ϳ��� ����� �Ǵ��ϱ����� �迭����
		int size= s.length(); 
		while(size>0) { // size�� 0���� Ŭ����
			check[s.charAt(size-1)-'a']++; // �ƽ�Ű �ڵ尪���̿��ؼ� 'a' = 97�̴ϱ� �̰��̿��ؼ�
			size--;
		}

		for(int i=0;i<25;i++) {
			System.out.print(check[i] + " ");
		}
		System.out.print(check[25]);
		System.out.println();
		
		
		
	}
}
