package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BF_2529 {
	static String s1[];
	static int a[];
	static boolean open[];
	static long max=-1;
	static long min=-1;
	static int maxS[];
	static int minS[];
	public static long mul(int i, int j) {
		long x=a[i];
		for(int q=0;q<j;q++) {
			x=x *10;
		}
		return x;
	}
	public static boolean check(int len) {
		String s=s1[len-2]; //���� 2���� �����ͼ�
		int first=a[len-2];
		int second=a[len-1];
		
		if(s.equals("<")){ //�ε�ȣ�� �� ���θ� �Ǵ��Ѵ�.
			if(first<second) {
				return true;
			}else {
				return false;
			}
		}else {
			if(first>second) {
				return true;
			}else {
				return false;
			}
			
		}
		
	}

	public static void go(int index, int n, int len) {
		if( index >= 2 && !(check(index)) ) { //���ڰ� 2�� �̻� ���ö����� �ε�ȣ�� ������ ���谡 ������ �ƴ��� �Ǵ��ؼ�
			return;			//���� �ƴ϶�� �� �̻� ���ȣ���� ���� �ʴ´�. 1<2 ��� 2<1 �̷��� ��� ���ʿ䰡����
		}
		
		if(index==n+1) { //index 3 ���ڰ� �ε�ȣ���� �Ѱ� �� ���õ� ��Ȳ�̶�� ���� �ּ� �ִ븦 ���������

			long sum=0;
			for(int i=0,j=n;i<=n;i++, j--) {
				long a=mul(i,j); // �迭�� �����ؼ� 0 ��° �ڸ��� 10�� n���̴ϱ� �̰� �̿��ؼ� �Ѱ��ְ�
				sum= sum+a; // ���ڷ� ������ش�.
				
			}
			if(max<sum) { //���ڰ� max���� ũ�� max�� ��ü���ְ� 
				max=sum;
				for(int i=0;i<=n;i++) {
					maxS[i]=a[i]; // ����� ���� �׶��� �迭�� �������ش�.
				}
			}
			if(min>sum || min==-1) { // -1 ��� �ִ� ������ �𸣴ϱ�  �ϴ� -1�� �����ؼ� ó���� ���Ѵ�
				min=sum; // ���ڰ� Ŀ���� ������ long �� �����غ��� !!!!!!!!!!!!!!!!
				for(int i=0;i<=n;i++) {
					minS[i]=a[i];
				}
			}
			return; // ���ڰ� �ε�ȣ���� 1�� �������� �� �������� �ʿ�����ϱ� ��͸� �����ش�.
		}
		
		for(int i=0;i<=9;i++) { // ��� ������ ��������
			if(open[i]) { // �̹� �湮�ߴ� ���ڶ�� ���� ���ڷ�
				continue;
			}
			open[i]=true; // ó�� �湮�ϸ� �湮üũ
			a[len]=i; // �׶��� index�� ����
			go(index+1,n,len+1); // index�� len�� ������Ű��
			open[i]=false; // ��Ͱ� ������ �ٽ� �湮���ѻ��·� �ٲ�����ϴϱ� false�� ���ش�.
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		s1 = br.readLine().split(" ");
		a = new int[n + 1]; // �ε�ȣ�� n����� ���ڴ� n+1�� �ʿ���
		open = new boolean[10]; //�湮 �ߴ��� üũ
		maxS= new int[n+1];// �ε�ȣ�� n����� ���ڴ� n+1�� �ʿ���
		minS= new int[n+1];// �ε�ȣ�� n����� ���ڴ� n+1�� �ʿ���
		
		go(0, n, 0); // 
		
		for(int i=0;i<=n;i++) {
			System.out.print(maxS[i]);
		}
		System.out.println();
		for(int i=0;i<=n;i++) {
			System.out.print(minS[i]);
		}
	}
}
