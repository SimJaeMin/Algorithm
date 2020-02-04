package kr.co.mlec.bf;

import java.util.Scanner;

public class BF_15649 {
	static boolean check[] = new boolean[10];
	static int a[];

	
	//��Ͱ� �߿��ϴ�
	//�ϳ��� ��Ȳ���� �� �� ��Ȳ���� ��� ��츦 �����Ҽ�����
	
	public static void go(int n, int m, int len) { //����Լ� , ���������� ���� ���� ã�� ���ִ�. dfs �Ҷ� ���� ��ġ�� ã�� ��ó��

		if (len == m) { // ���̰� �Է¹��� m�ڸ� �� �������ٸ� ���

				for (int j = 0; j < m; j++) {
					System.out.print(a[j] + " ");
				}
				System.out.println();
			return; // ����ϰ� �� ���� �Լ��� ������ �Ŵϱ� return 
		}

		for (int i = 1; i <= n; i++) { //������ ���� �� 1 ���� ����  , 1���� n ���� �� �� �ְ�
			if (check[i]) { // �ߺ��� �ȵǴϱ� ���࿡ �湮�� ���ڸ� �Ѿ�ְ� 
				continue;
			}
			check[i] = true; // �湮�� �ȵǼ� ���� �ϴ� �Ÿ� true�� ����� �ְ�
			a[len] = i; // �� �� �� ���� len ( index ) �� �°� ���� ���ش�.
			go(n, m, len + 1); // �׸��� m �ڸ� ���� ������ ���ϴ°Ŵϱ� �� ���� ���� ���ϱ� ���� ����Լ��� �����µ�
							   // index �� ���� �� �����Ѿ� �ϴϱ� +1�� ���� ���� �Ѱ��ش�.
			check[i] = false; // �ϳ��� ������ ã���� ���� �Ÿ� ���� true ���� �� false �� �ٽ� �ٲ��ش�.

		}

		return;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[m];
	
		go(n, m, 0);
	}
}
