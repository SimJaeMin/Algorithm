package kr.co.mlec.math;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Math_17298 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		
		int[] v = new int[1000001];
		int[] v1 = new int[1000001];
		for (int i = 0; i < num; i++) {
			v[i]=sc.nextInt();
		}

		Stack<Integer> s = new Stack<Integer>();
		s.push(0); // ó�� �ε����� ����  �ε����� �����ϴ� ������ �� �ε��� ��°���� ū ���� ���� ���ʿ� �ִ� ���� �� �ε����� �ٽ� �����ؾߵǴϱ�
		
		for (int i = 1; i < num; i++) {

			while (!s.isEmpty() && v[s.peek()] < v[i]) { // ������ ��������ʰ� ������ top�� �ִ� �ε����� �̿��� v[i]�� ���ؼ� v[i]�� ũ�� �ڱ⺸�� ū ���� ���� �������°Ŵϱ�
				v1[s.peek()] = v[i]; // �� ���� v1�� �� �ε����� ����
				s.pop();
			}
			
			s.add(i);
		}
		
		while(!s.isEmpty()) {
			v1[s.pop()]=-1; // ���ÿ� �����ִ� �ε����� �ڱ⺸�� ū���� �����ʿ� ���°Ŵϱ� -1�����ش�.
		}
		
		for(int i=0;i<num;i++) {
			sb.append(v1[i] + " "); //����� ������ �ð��ʰ��� ���� sb��
		}
		System.out.println(sb);
	}
}
