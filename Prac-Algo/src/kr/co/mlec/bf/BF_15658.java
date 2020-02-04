package kr.co.mlec.bf;


import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class BF_15658 {
	static int data[];
	static Vector<Integer> v;
	static int max=-1000000000;
	static int min=1000000000;
	static boolean check[];
	static int data1[];
	public static void go(int n,int curLen,int val,int plus, int minus, int mul,int div) {
		if(curLen==n) { // ��� ���ڸ� �� ����ϸ� �׶� ���� ���Ϳ� �����ϰ� ���߿� max ,min ã����
			v.add(val);
			return;
		}
		
		//���������� ������ �� ���� ������ ���� 2����������
		//������ �ѹ��� ������ �� �ִ°� 4������ �ٲ�, +,-,*,/ �׷��� 4������ ��������
		//���������� ������ ���ִ°� 2���� , ������ 4�ڱ�
		if(plus>0) {
			go(n,curLen+1,val+data[curLen],plus-1,minus,mul,div);
		}
		
		if(minus>0) {
			go(n,curLen+1,val-data[curLen],plus,minus-1,mul,div);
		}
		
		if(mul>0) {
			go(n,curLen+1,val*data[curLen],plus,minus,mul-1,div);
		}
		
		if(div>0) {
			go(n,curLen+1,val/data[curLen],plus,minus,mul,div-1);
		}
	}
	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		data=new int[n];
	
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		
		data1=new int[4];
		for(int i=0;i<4;i++) {
			data1[i]=sc.nextInt();
			
		}
		v = new Vector<Integer>();
		go(n,1,data[0],data1[0],data1[1],data1[2],data1[3]);
		
		
		Collections.sort(v);
		System.out.println(v.get(v.size()-1));
		System.out.println(v.get(0));
	}
}
