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
		if(curLen==n) { // 모든 숫자를 다 사용하면 그때 값을 벡터에 저장하고 나중에 max ,min 찾아줌
			v.add(val);
			return;
		}
		
		//이전까지는 선택이 이 값을 넣을까 말까 2가지였지만
		//지금은 한번에 선택할 수 있는게 4가지로 바뀜, +,-,*,/ 그래서 4가지로 나눈거임
		//이전까지는 선택할 수있는게 2가지 , 지금은 4자기
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
