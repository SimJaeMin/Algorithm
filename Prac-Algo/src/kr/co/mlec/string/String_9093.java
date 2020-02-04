package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class String_9093 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count= Integer.parseInt(br.readLine());
		String s[];
		int size;
		for(int i=0;i<count;i++) {
			s= br.readLine().split(" ");
			
			for(int j=0;j<s.length;j++) {
				size=s[j].length()-1;
				for(int z=size;z>=0;z--) {
					System.out.print(s[j].charAt(z));
				}
				System.out.print(" ");
			}
			
			System.out.println();
		}
	}
}
