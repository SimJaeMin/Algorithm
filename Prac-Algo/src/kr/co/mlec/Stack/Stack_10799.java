package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;

//������ : �踷���
//������ȣ : 10799
public class Stack_10799 {
	public static void main(String[] args) {
	
	
	// ( �� ������ stack �� ����� ���� ��Ű�� push, 
	// ) �� ������ ���� �������� ���� ( �ε����� ���ؼ� �����ϸ� stack��  pop�� �ϳ����ְ� stackd�� ������ ��ŭ ����
	// ) �� ���Դµ� �����Ѱ� �ƴϸ� ����Ⱑ ������ ���̰� �׷��� �� �κ��� ©�������ϱ� +1 �� ���ش�.
	Stack<Integer> s = new Stack<Integer>(); // ( �� ������ Ǫ�� ) �� ������ pop�� ���ش�.
	// integer�� ���������� ������ ( index�� Ȯ���ϱ����ؼ��̴�
	int jud=0; // ������ ( �� �����ϱ�����
	char a; //����⸦ �ϳ��� �б�����
	int sum=0 ; //���� ����� ���� �����ϱ�����
	Scanner sc= new Scanner(System.in);
	String stick=sc.next(); //����� �Է�
	int size=stick.length(); //������� ����� ���Ѵ�
	
	for( int i=0;i<size;i++) {
		a=stick.charAt(i); // ù��° ���Һ��� �о�� �����ؼ�
		
		if(a=='(') {
			s.push(i); // ( �� push �����ְ� 
		}else {
			jud=s.pop(); // ) �� pop�� ������ 
			if(jud+1==i) { // ������ () ���� �Ǵ����� 
				sum=sum+s.size(); // �����ϴٸ� size ��ŭ
			}else { // �������� �ʴٸ� +1 (������ �����ϱ� ������ ó��)
				sum=sum+1;
			}
		}
	}
	System.out.println(sum);
	}
}
