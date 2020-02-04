package kr.co.mlec.bf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BF_1339 {
	static int al[];
	public static void sq(char a, int len) {
		int num=1; 
		for(int i=1;i<len;i++) { //1부터 시작하는 이유는 1의 자리는 * 10 을 할 필요가없으니까
			num=num*10; 
		}
		al[a-'A']=al[a-'A']+num; // 아스키코드 값을 이용해서 뺴주면 그 때의 인덱스가 되고 * 10 해준값을 그 인덱스에 더해준다.
	}
	public static void rever(int[] a) { // 오름차순되있는 배열을 내림차순으로 변환해준다.
		int size=a.length-1; //사이즈는 1부터시작하니까 1을 빼줘야 인덱스에 접근 할 수 있음
		int size1=size/2; // 사이즈를 2로 나눈만큼만
		for(int i=0;i<size1;i++) {
			int temp=a[i];
			a[i]=a[size-i]; 
			a[size-i]=temp;
		}
	}
	public static void main(String[] args) {
		//BACD , EFGB 이런식으로 입력이 오면
		//이거는 (1000B + 100A + 10C + D) +  (1000E + 100F + 10G+ B) 이거임
		//이거는 (1001B + 1000E + 100A+ 100F+ 10C + 10 G + D )임
		//이거를 그냥 젤 큰수부터 9부터 하나씩 배정하면됨
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		String s[] = new String[num];
		al= new int[26]; //대문자 26개
		for(int i=0;i<num;i++) 
		{
			s[i]=sc.next(); //문자열입력
		}		
		
		for(int i=0;i<num;i++) { //입력받은 문자열 1부터 N 까지
			int len=s[i].length(); // N번째 문자열의 길이를 구한후
			for(int j=0;j<s[i].length();j++) { // 그 문자열이 4자리면 1000, 3자리면 100 ....
				char a=s[i].charAt(j); // 첫번재 자리 얻고
				sq(a,len); // 그때 자리수만큼 10을 곱해서
				len--;
			}
		}
		Arrays.sort(al);
		rever(al);
		int sum=0;
		int aa=9;
		for(int i=0;i<al.length;i++) {
			if(al[i]==0) {
				break;
			}
			sum=sum+al[i]*aa;
			aa--;
		}
		System.out.println(sum);
	}
}
