package kr.co.mlec.simul;

import java.util.Scanner;
import java.util.Vector;

class Pair{
	int num;
	int red;
	int green;
	public Pair(int num, int red, int green) {
		this.num = num;
		this.red = red;
		this.green = green;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	
	
}
public class Simul_2980 {
	static Vector<Pair> v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		v = new Vector<Pair>();
		for(int i=0;i<n;i++) {
			v.add(new Pair(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		int len=0; //�� �ɸ��ð�
		int len1=0; // �̵��Ÿ�
		int stop=0; // ����ð�
		for(int i=0;i<v.size();i++) {
			Pair p = v.get(i); 
			int y=p.num-len1; //3, 2 ���� ��ġ���� ���� ��ȣ����� �ɸ��� �ð�
			
			len=len+y; // 3 ->5 , 7
			len1=len1+y;//3, 5
			
			
			int x= len % (p.green + p.red);// 3 //��ȣ�� ������ �ݺ��� �׷��� �������� Ȱ���Ѵ�.
			//�����Ұ� �Ķ��� �ð��� �ٸ� �� �����Ƿ� �ΰ��� ���Ѵ��� ���ݱ��� �ɸ��ð��� �����ָ� �������� �����µ�
			//�̰� �����Һ��� ũ���� �Ķ��� �ð����̰� �����Һ��� ������ �������̶�� ������ŭ ��ٷ����Ѵ�.
			if(x<p.red) {  //������ ������ŭ ��ٸ��� 
				stop=p.red-x; // 2
			}
			len=len+stop; //5 7 // �ѹ� ��ȣ���� ���������� ��ٸ��ð� �����ֱ�
			stop=0;
			//�ϳ��� ��ȣ���� ���������� ��ȣ�� ��ٸ� �ð��� ���ݱ��� �� �ɸ� �ð��� ������� ������ ��ȣ���� ���������� ���Ҽ�����
		}
		len1=l-len1; // ��ȣ���� ���� ���� �Ÿ��� ���ϱ� ���� ��ü�Ÿ����� ���ݱ��� ��ȣ�ɸ� �ð� ������ �̵��Ÿ��� ���Ѱ� ���ش�.
		System.out.println(len+len1);
	}
}
