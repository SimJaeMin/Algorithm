package kr.co.mlec.Stack;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Stack_1874 {
	static Vector<Integer> v;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int last = 1; // �ֱ�����ؾ��ҹ�ȣ
		v = new Vector<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder(); //����� �� �ð��ʰ� �������־

		for (int i = 0; i < n; i++) { // �� n�ڸ����� ������ �Է¹���
			int num = sc.nextInt(); // ������ n��° �ڸ���
			if (last <= num) { //last�� �ʱ� 1 , ���� �� ������ �Է¹��� n��° �ڸ����� ũ��  
				for (int a = last; a <= num; a++) { // �׸�ŭ push�� ���ش�.
					stack.push(a); 
					sb.append("+\n");
				}
				stack.pop(); // push ���ְ� ���������� ������ ������� pop ���ؾߵǴϱ� �ϳ� ���ش�.
				sb.append("-\n");
				last=num+1; //������, ���������� �Է¹޾Ƽ� �̰ź��� �������� ������ pop�� �ؾߵ�
			} else {
				int c = stack.pop(); // ���࿡ ������ �Է¹����ź��� ������ ���� , �װ� �� ���� ������ �ڸ��� �Ǵ°Ŵϱ� �� �ѹ��� pop�� ���ָ��
				if (c == num) { //pop ���ذ� ���� �Է¹��� ���� ������ ������ �̾��������
					sb.append("-\n");
				} else {
					System.out.println("NO"); //�ٸ��� �ٷ� no
					return;
				}
			}
		}


		System.out.println(sb);
	}
}
