package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;
class Pair111{
	int x;
	int y;
	public Pair111(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
public class BF_16197 {
	static int n;
	static int m;
	static int data[][];
	public static void go(int cnt,int x1, int y1, int x2, int y2) {
		
		if
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		n =Integer.parseInt(s[0]);
		m =Integer.parseInt(s[1]);
		
		data=new int[n][m];
		Vector<Pair111> v = new Stack<Pair111>();
		for(int i=0;i<n;i++) {
			String s1=br.readLine();
			for(int j=0;j<m;j++) {
				
				if(s1.charAt(j)=='.') {
					data[i][j]=1;
				}else if(s1.charAt(j)=='#') {
					data[i][j]=-1;
				}else {
					data[i][j]=0;
					v.add(new Pair111(i,j));
				}
			}		
		}
		
		go(0,v.get(0).x,v.get(0).y,v.get(1).x,v.get(1).y);
	}
}
