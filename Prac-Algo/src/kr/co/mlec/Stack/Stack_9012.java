package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;

//������ : ��ȣ
//������ȣ :9012
public class Stack_9012 {
	public static void main(String[] args) {
		int num=0; // ( �� ������ �˱�����
		Scanner sc = new Scanner(System.in); //��� �ݺ� ������ �Է¹ޱ� ���ؼ���
		int cnt = sc.nextInt();
		String ps; // ��ȣ���ڿ��� �Է¹ޱ����� ����
		for (int i = 0; i < cnt; i++) { //��� �ݺ� �Ұ��ΰ�
			ps = sc.next(); // ��ȣ���ڿ� �Է¹ް�
			int size = ps.length(); //��ȣ���ڿ��� ũ�⸸ŭ �ϱ�����
			num=0; //�ѹ� ������ num�� �ٽ� 0���� �ʱ�ȭ
			for (int j = 0; j < size; j++) {
				char a = ps.charAt(j); // ù��° ���Һ��� ã�Ƽ�
	
				if(a=='(') { // ( �� ������ num�� ����
					num=num+1;
					
				}else {
					num=num-1; // ) �������� num ����
				}
				
				if(num<0) { // num �� ���̳ʽ��� �ȴٴ� ���� ) �� ���� �տ����� ( ������ ���ų�, ù��°�� ���°��̱⿡ ps���ƴ�
					System.out.println("NO");
					break;
				}
			}
			
			if(num==0) { // num �� 0�� ��°��� (�� )�� ������ ���� ���ٴ� ���̱⿡ yes
				System.out.println("YES");
			}else if(num>0){ //0���� ũ�ٴ� ���� ) �� ���� (���� �����ϱ⿡ NO
				System.out.println("NO"); 
			}
		}

	}
}
