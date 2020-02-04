package kr.co.mlec.math;

import java.util.Scanner;
import java.util.Stack;

public class Math_17299 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int f[] = new int[1000001]; //�� ���ڰ� ���������
		int a[] = new int[1000001]; //����
		int a1[] = new int[1000001]; //������ ����ū���� �����ϱ����� �迭
		
		for(int i=1;i<=n;i++) {
			int n1=sc.nextInt();
			a[i]=n1; // ������ �����ϰ�
			f[n1]++; // �� ���� ���� �ε����� �����ؼ� ��� ���Դ��� Ȯ��
		}
		
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> s1 = new Stack<Integer>();
		s.push(a[1]); // ���� 
		s1.push(1); //�ε����� 
		
		//�ε����� ���� ���� ������
		//���� �־�� ���� ���°��� ������ ���� ���麸�� ū���� �������� �˼� �ְ�
		//ū���� ���������� �Ǵ��ϸ� �� �ε����� ������������ϱ⶧���� ������
		for(int i=2;i<=n;i++) {
			
			while(!s.isEmpty() && f[s.peek()] < f[a[i]]) { // ���� ������ �迭���� ���� ������ �� �� ���°��� ���� ���ϴ°ͺ��� ���� ���Դٸ�
				a1[s1.peek()]=a[i]; // ����ū���� ���Ѱű� ������ ����
				s.pop();// �� �������� �����ֱ�����
				s1.pop(); // �� ��� �ε���
			}
			s.push(a[i]);
			s1.push(i);
		}
			
		while(!s1.isEmpty()) {
			a1[s1.pop()]=-1; // ���ÿ� �����ִ� �ε����� ����ū���� ���� ������
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			sb.append(a1[i]+ " ");
		}
		System.out.println(sb);
	}
}
