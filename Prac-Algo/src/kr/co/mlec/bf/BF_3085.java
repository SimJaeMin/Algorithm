package kr.co.mlec.bf;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BF_3085 {
	static ArrayList<Character>[] a; // 2���� �迭�� ���� ����
	static int max = 1; // ���� �� ���� �� ������ ������ �����ϱ�����

	static int check(int n) {
		int count = 1; // �ٲ� ���¿��� �ִ� ���̸� ã���� ��,�� 2���� ��������  �ؾߵǼ� 
		int count2 = 1; // count ���� 2������
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					if (a[i].get(j) == a[i].get(j + 1)) { //�ڱ�� ������ ���Ҹ� ���ؼ�
						count++; // ������ count ����
						if (max < count) { // �׋� max ������ Ŀ���� max �� ��ü
							max = count;
						}
					} else { // �ٸ��� count �� �� �� �ٽ� �����̴ϱ� 1�μ���
						count = 1;
					}
				}
				if (j + 1 < n) {
					if (a[j].get(i) == a[j + 1].get(i)) { // �ڱ� �Ʒ��� ��������
						count2++;
						if (max < count2) {
							max = count2;
						}
					} else {
						count2 = 1;
					}
				}
			}
			count = 1; //�ϳ��� ��,���� ������ �ٽ� �����̴ϱ� 1�� �ʱ�ȭ
			count2 = 1;
		}
 
		return max; // �ִ밪 ����

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //�ʱ� n ���� �Է¹޴´�.
		int n = Integer.parseInt(br.readLine()); //�ʱ� n ���� �Է¹޴´�.
		int num; // �ڱ���� ������ �� �Ʒ��� �ٲ� �� ���� �ִ밪�� ������ �ִ밪�� ���ϱ�����
		int num1=1; // �ڱ���� ������ �� �Ʒ��� �ٲ� �� ���� �ִ밪�� ������ �ִ밪�� ���ϱ�����
		a = (ArrayList<Character>[]) new ArrayList[n]; // ArrayList[] ����
		char temp; //swap �� �� �ӽ������
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Character>(); //������ ArrayList<Character> ����
		}
		for (int i = 0; i < n; i++) { // �������Է�
			String s = br.readLine(); // ���� �Է¹ް�
			for (int j = 0; j < n; j++) { // ���ڿ��� charAt �Լ�����ؼ� �ϳ��� ����
				a[i].add(s.charAt(j));
			}
		}
		for (int i = 0; i < n; i++) { // n*n ����̴ϱ� n����
			for (int j = 0; j < n; j++) { // 1���̵� 1���̵� n ���� ������
				if (j + 1 < n) { // �ڱ�� �ڱ� �������� ���ϴµ� j�� n ���� �������� ������ �ʰ��ϴϱ�
					temp = a[i].get(j); //�ٲ� ��� 
					a[i].set(j, a[i].get(j + 1)); //�ٲ� ����� ���� �� ������ ����
					a[i].set(j + 1, temp); // �ٲٱ�
					num=check(n); // �ٲ� ���¿��� �ִ���� ã��
					if(num1<num) { // �ִ���� ã���� ������ �ִ���̺��� ��� �ٲٱ�
						num1=num;
					}
					
					temp = a[i].get(j); // �ٽ� ���󺹱�
					a[i].set(j, a[i].get(j + 1));
					a[i].set(j + 1, temp);
				
				
					temp=a[j].get(i); // ���� �����ε� �̰Ŵ� ��
					a[j].set(i,a[j+1].get(i));
					a[j+1].set(i, temp);
					
					num=check(n);
					if(num1<num) {
						num1=num;
					}
					temp=a[j].get(i);
					a[j].set(i,a[j+1].get(i));
					a[j+1].set(i, temp);
			}
		}
	}
		System.out.println(num1);
}
}