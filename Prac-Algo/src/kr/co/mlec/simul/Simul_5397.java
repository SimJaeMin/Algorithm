package kr.co.mlec.simul;

import java.util.Scanner;
import java.util.Stack;

public class Simul_5397 {
	//Ŀ���� �������� ����, ���������� ����� �ذ��ϱ�
	//Ŀ���� <�� ������ ���� ������ ����� 0���� Ŀ�ߵǰ� ���� ũ�ٸ� ���� ������ ž�� ������ ���ÿ� �־��ش�.
	// >�� �ݴ��
	//-�� Ŀ���� ���ʰ� �ϳ� �����ִ°ǵ� �̶��� ������ üũ���ֱ�
	// ������ ����� ���� �������°Ŵ� ���� ù��°�ϱ� �̰� �������� �ٲ��ֱ����� �� ���������� �Ѱ��ְ� �����ʰ� pop() ���ֱ�
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			StringBuilder sb = new StringBuilder();
			String s = sc.next();
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			for (int i1 = 0; i1 < s.length(); i1++) {
				char c = s.charAt(i1);

				if (c == '<') {
					if (left.size() > 0)
						right.add(left.pop());
				} else if (c == '>') {
					if (right.size() > 0)
						left.add(right.pop());
				} else if (c == '-') {
					if (left.size() > 0)
						left.pop();
				} else {
					left.add(c);
				}
			}

			while (!left.isEmpty()) {
				right.add(left.pop());
			}

			while (!right.isEmpty()) {
				sb.append(right.pop()); //����� ���� ���� ������ �̰� ��ߵɵ�
			}
			System.out.println(sb);
		}
	}
}
