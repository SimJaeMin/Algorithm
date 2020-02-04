package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_1107 {
	static boolean n[]; // ��ȣ��ư 0~9

	static boolean check(int num) { // num �� ��������ä��
		int temp;
		if (num == 0) { // ó�� 0���� ����
			if (n[num]==true) { // ture ���Ǹ� ���峭�Ŵϱ� ���� ����ä����
				return false; // false ����
			} else { // ture�� �ƴϸ� �����ִ� ä����
				return true; // ture ����
			}
		}

		while (num > 0) { // ä���� ��ȣ �� �˻��غ����ϴϱ�
			temp = num % 10; // ���ڸ��� �˻�
			num = num / 10;
			if (n[temp]==true) { // �� �ڸ��� true�� ���峭�Ŵϱ� �ϳ��� ���峪�� false ����
				return false;
			}
		}
		return true; // ���� �� ����ϸ� true ����
	}
	// ���� ä�η� �̵��Ѵ��� �� ���� +, - �� �ϳ��� �����ؼ� ������ �ּҸ� ���� �� ����
	// ������ �ߺ��� ����ߵǴϱ�
	// ���Ʈ���� -> �ѹ��� ���غ�����
	// �׷��� ��ó���� +�� -�θ� ���°��(�־�) ��� ��ȣ�� ���峪�� �̰�츦 �������� ������
	// 1ä�κ��� 10000000���� ���� �� �� +,- �� �� �ϳ��θ� �������ä�ηΰ��µ� �׶� �ּҰ������ϸ�ȴ�.
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int changeNum = sc.nextInt(); // �ٲ� ä�ι�ȣ
		int errCount = sc.nextInt(); // ���峭 ��ȣ ����
		int min; // �ּҰ�
		
		if (errCount > 0) { // ���峭 ��ȣ ������ 1�� �̻��̸�
			n = new boolean[10];
			for(int i=0;i<errCount;i++) {
				n[sc.nextInt()]=true;
			}
		}else {
			n= new boolean[10]; //������ �׳� ���������ֱ�
		}

		
		if (changeNum == 100) { // ���� 100���� �������ϸ�
			System.out.println(0); // ���� 100�̴ϱ� �������ʿ� x
			return;
		}
		min = changeNum - 100; // ��� ��ȣ�� ���峵���� +,-�θ� ���°��
		if (min < 0) { // 0 ���� ������ �ٽ� ����� ���ֱ�����
			min = -min;
		}

		for (int i = 0; i <= 1000000; i++) { // 0�� ä�κ��� 1000000���� �ѹ��� ä�η� �� ���� �ű⼭ +,-�� �������� ������ ��츦 �� �غ���
			int count = 0; // +,- ���� ������ ��ȣ�� ������ ����
			
			if (check(i)) { // �ϴ� ä���� �����ִ��� Ȯ��
				int temp = i; // ��� ��ȣ�� ������
			
				if (temp == 0) { // 0 ä�η� ���� 0 �ѹ��̴ϱ� count�� 1
					count++;
				} else {
					while (temp > 0) { // 0�� �ƴϸ� 10���� ����� ���ڸ� ������ �ľ��ϰ� �� ����ŭ cout ���� (��ȣ������ ������)
						count++;
						temp = temp / 10;
					}
				}

				if (i < changeNum) { // i�� ������ ä�κ��� ������
					int a = changeNum - i + count; // ���ְ� + ä�η� �������� ���� ���� �����ֱ�
					if (min > a) { // �� �� �� ���� min ���� ������ �ּҰ��̵Ǵ°���
						min = a;
					}
				} else if (i == changeNum) { // �������� count�� ��
					if (min > count) {
						min = count;
						break;
					}
				} else {
					int a = i - changeNum + count; // i�� ũ�� i���� ���ֱ�
					if (min > a) {
						min = a;
					}
				}

			}
		}
		System.out.println(min);

	}
}
