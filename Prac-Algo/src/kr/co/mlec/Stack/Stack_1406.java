package kr.co.mlec.Stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//������ : ������
//������ȣ 1406
public class Stack_1406 {
	public static void main(String[] args) throws IOException {
		//�ʱ⿡ �Է¹��� �� �ִ� ���ڿ� ���� 100,000
		//��ɾ� �Է¹޴� Ƚ�� 500,000
		//���ļ� 600,000 �ε� �迭�� ������ Ǯ�ԵǸ� 
		// (������ ũ�� N ) * (�� ������ �ɸ��� �ִ� ũ�� N) �迭�� ���� ������ �ð��� N��ŭ �ɸ��⶧��
		// O(N�� ����) �� �Ǵµ� ;�ð����� ���� �迭�� ������ STACK �� 2���� �Ἥ �ؾ��Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> left = new Stack<Character>(); //Ŀ���� �������� ����
		Stack<Character> right = new Stack<Character>(); //Ŀ���� �������� ������
		String init = br.readLine(); //�ʱ� ���ڿ��Է�
		int cnt=Integer.parseInt(br.readLine());

		int size=init.length();
		
		for(int i=0; i < size ; i++) { // �ʱ⿡ Ŀ���� ���� �����ʿ� ������
			left.push(init.charAt(i)); // �ʱ� �����ʹ� ���� Stack�� 
		}
		
		for(int i=0;i<cnt;i++) { // ī��Ʈ ��ŭ �Է��� �ް�
			String[] line=br.readLine().split(" ");
			if(line[0].charAt(0)=='L') { //Ŀ���� �������� ���ϱ�
				if(!left.empty()) // ���� stack�� ������
				right.push(left.pop()); //�ϳ��� ������ ����������
			}
				else if(line[0].charAt(0)=='D') { //Ŀ���� ���������� ���ϱ�
					if(!right.empty()) { //right stack �� ������
						left.push(right.pop()); //�ϳ��� ������ ��������
					}
				}else if(line[0].charAt(0)=='B') { //Ŀ�� ���ʿ� �ִ°� ����
					if(!left.empty()) { // left stack ��������
						left.pop(); //�ϳ����׳� ������
					}
				}else if(line[0].charAt(0)=='P') {// �����̸�
					char add=line[1].charAt(0); //�����ϳ� ���� ������ ���ڸ� �Է��ϴϱ� 2��°
					left.push(add); // ���ʿ� �߰��ϴϱ� left
				}
				
			}
		size=left.size();
		for(int i=0;i<size;i++) { //����ϱ� ���ؼ�
			right.push(left.pop()); //���ʿ� �ִ°Ŵ� ������ �ݴ���� �̰� �ٽ� ������ ���ؼ� ���������� �� �ű��.
		}
		StringBuilder sb=new StringBuilder(); //String�� ȿ�������� ��������
		while(!right.empty()) {
			sb.append(right.pop()); // append�� �̿��� �̾��ش�.
		}
		System.out.println(sb);
	}
}
