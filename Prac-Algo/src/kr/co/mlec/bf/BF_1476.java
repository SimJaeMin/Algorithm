package kr.co.mlec.bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BF_1476 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int a=1;
		int b=1;
		int c=1;
		for(int i=1;;i++) {
			if(a==E && b==S && c==M) {
				System.out.println(i);
				break;
			}
			a++;
			b++;
			c++;
			if(a>15) {
				a=1;
			}
			if(b>28) {
				b=1;
			}
			if(c>19) {
				c=1;
			}
		}
	}

}
