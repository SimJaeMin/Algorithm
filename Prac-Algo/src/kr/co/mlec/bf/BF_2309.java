package kr.co.mlec.bf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BF_2309 {
	public static void main(String[] args) {
		//9C2 임 9명중 난쟁이가 아닌 2명을  찾으면 되는거임
		//2중 FOR 문으로 하나당 전체를 비교하는 방식으로
		//2개의 수를 다 던하거에서 뺏을때 값이 100이 되면 나머지 7명의 키의 합이 100이되는거니까
		//난쟁이를 찾을수있음
		int sum=0;
		Scanner sc= new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<9;i++) {
			a.add(sc.nextInt());
			sum=sum+a.get(i);
		}
		Collections.sort(a);
		
		for(int i=0;i<9;i++) {
			int one = a.get(i);
			for(int j=i+1;j<9;j++) {
				int two=a.get(j);
				if(sum - one - two ==100) {
					for(int z=0;z<9;z++) {
						if(z!=i && z!=j) {
						System.out.println(a.get(z));
						}
					}
					return;
				}
			}
		}
	}
}
