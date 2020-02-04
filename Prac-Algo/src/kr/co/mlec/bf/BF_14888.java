package kr.co.mlec.bf;

import java.util.Scanner;
import java.util.Vector;

public class BF_14888 {
	static Vector<Integer> v;
	static Vector<Integer> v1;
	static boolean check[];
	static int min, max;
	static int count = 0;
	static int num[];

	public static void bf(int n, int len, int vsize, int sum) {

		if (len == n) { // ���� len�� n�� ���ٸ� ��� �����ڸ� ������ ���ϱ� �׶��� �� min, max�� ��
			if (count == 0) {
				min = sum;
				max = sum;
				count = 1;
			} else {

				if (min > sum) {
					min = sum;
				}

				if (max < sum) {
					max = sum;
				}
			}
			return;
		}

		for (int i = 0; i < vsize; i++) { // ��� �����ڸ� ����ϱ�����

			if (check[i] == true) { //�ѹ� ����� �����ڴ� �� ������ �ٽ� ����� ���ϰ� �ϱ�����
				continue;
			}
			check[i] = true; //�ѹ� ����� ������ üũ

			if (v.get(i) == 0) { // ���� �� �����ڰ� + ���
				bf(n, len + 1, vsize, sum + num[len]);
			} else if (v.get(i) == 1) { //-���
				bf(n, len + 1, vsize, sum - num[len]);

			} else if (v.get(i) == 2) {//* ���
				bf(n, len + 1, vsize, sum * num[len]);

			} else { // /���
				bf(n, len + 1, vsize, sum / num[len]);
			}
			check[i] = false; //�ѹ��� �������� ���������ٰ� �����ؼ� ���� �װŴ� ���� ���� ���������� ��밡�������ߵǴϱ� ������ false�� �ٱ���
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �Է� ���� ���� , ������ ������ �ٲܼ� ����.
		num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt(); // �����Է�
		}

		v = new Vector<Integer>(); //������ ����ϱ����� �Էµ� �����ڸ� 1�ڷ� ���.

		for (int i = 0; i < 4; i++) { // +,-,*,/ �� ���� �������
			int n1 = sc.nextInt(); // ����� �Է�
			for (int j = 0; j < n1; j++) {
				v.add(i); // �� ����ŭ + �� 0 , - �� 1 ... �̷��� ������ �Է��Ѵ�.
			}
		}
		check = new boolean[v.size()]; // �ѹ� ����� �����ڴ� ����Ҽ� ������ ����ߴٰ� üũ���ֱ� ���� �迭
		bf(n, 1, v.size(), num[0]);//n len�� 1���Ͱ��������� ù��° ���� ó���� �Ѱ��ִϱ� �׸��� v.size() ��ŭ ������ ���� ��� ����Ǽ��� �� �� �� ����
		System.out.println(max);
		System.out.println(min);
	}
}
