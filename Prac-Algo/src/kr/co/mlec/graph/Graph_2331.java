package kr.co.mlec.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph_2331 {
	static Map<Integer, Integer> map;

	static int pow(int a,int p) {
		int num=1;
		while(p>0) {
			num=num*a;
			p--;
		}
		return num;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int p=sc.nextInt();
		int tmp=0;
		int count=1;
		map = new HashMap<Integer, Integer>();
		boolean tf =true;
		map.put(num, count);
		while(tf) {
			while(num>0) {
				tmp = tmp + pow(num%10,p);
				num=num/10;
			}
			if(map.get(tmp) == null) {
				count++;
				map.put(tmp, count);
			}else {
				System.out.println(map.get(tmp)-1);
				break;
			}
			num=tmp;
			tmp=0;
		}
		
	}
}
