package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair11{
	int first;
	int second;
	public Pair11(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
public class Graph_14226 {
	static int numScreen=0;
	static int numClip=0;
	static boolean check[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		Queue<Pair11> q = new LinkedList<Pair11>();
		q.add(new Pair11(1,0));// �ʱ⿡�� ȭ�鿡 1�� , Ŭ���� 0 ��

		check=new boolean[1002][1002];
		check[1][0]=true; //�̰Ŵ� �湮�Ѱ�
		boolean t=true;
		int num=0;
		while(!q.isEmpty() && t) {
			num++;
			int size= q.size();
			
			for(int i=0;i<size;i++) {
				Pair11 next = q.poll(); 
				numScreen=next.first; // ���� ȭ�鿡 �ִ� ��
				numClip = next.second; // ���� Ŭ�����ִ� ��
				
				if(numScreen <=1001 && numScreen>0) { // ���� ȭ�鿡 �ִ°� 0���� ũ�� 1001 ���� ������ ȭ�鿡 �ִ°� Ŭ���� �ٿ��ֱ� �� ������
					//�׷��� Ŭ�����ִ� ���� ȭ���� ���� ��������. �ٿ��ֱ��ϸ� ������ �����Ŵ� ����Ⱑ �Ǵϱ�
					if(check[numScreen][numScreen]==false)
					q.add(new Pair11(numScreen,numScreen));
					check[numScreen][numScreen]=true;
				}
				
				if(numClip>0 && numScreen+numClip <=1001 ) { //s�� �ִ밡 1000�� �̰� �ȳ����� 
					if(check[numScreen+numClip][numClip]==false) { // Ŭ���� �ִ°� ȭ�鿡 �߰���Ű�°� �̶��� ���� 1001���� �۾ƾ���
						q.add(new Pair11(numScreen+ numClip,numClip));
						check[numScreen+numClip][numClip]=true;
					}
				}
				
				if(numScreen>2) { // ȭ�鿡 0���� �Ǹ� �ȵǴϱ� 2�� �̻��϶� 1���� ���ټ�����
					if(check[numScreen -1] [numClip]==false) {
						q.add(new Pair11(numScreen-1,numClip));
						check[numScreen-1][numClip]=true;
					}
				}
				
				if(numScreen==s) { //ã�¼��� ȭ�鿡 �ִ� �̸�Ƽ�� ���� ������ 
					t=false;
					break;
				}
			}
		}
		
		System.out.println(num-1);
		
	}
}
