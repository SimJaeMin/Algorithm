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
		int len=0; //총 걸린시간
		int len1=0; // 이동거리
		int stop=0; // 멈춘시간
		for(int i=0;i<v.size();i++) {
			Pair p = v.get(i); 
			int y=p.num-len1; //3, 2 현재 위치에서 다음 신호등까지 걸리는 시간
			
			len=len+y; // 3 ->5 , 7
			len1=len1+y;//3, 5
			
			
			int x= len % (p.green + p.red);// 3 //신호등 무한히 반복임 그래서 나머지를 활용한다.
			//빨간불과 파랑색 시간이 다를 수 있으므로 두개를 더한다음 지금까지 걸린시간을 나눠주면 나머지가 나오는데
			//이게 빨간불보다 크면은 파랑불 시간대이고 빨간불보다 작으면 빨간불이라고 작은만큼 기다려야한다.
			if(x<p.red) {  //작으면 작은만큼 기다리고 
				stop=p.red-x; // 2
			}
			len=len+stop; //5 7 // 한번 신호등을 지날때마다 기다린시간 더해주기
			stop=0;
			//하나의 신호등을 지날떄마다 신호등 기다린 시간과 지금까지 총 걸린 시간을 더해줘야 다음에 신호등이 무슨색인지 구할수있음
		}
		len1=l-len1; // 신호등이 없는 남은 거리를 구하기 위해 전체거리에서 지금까지 신호걸린 시간 제외한 이동거리만 구한걸 뺴준다.
		System.out.println(len+len1);
	}
}
