package kr.co.mlec.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//���ڿ� �м�
//10820
public class String_10820 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int []check= new int[4];
		
			while(sc.hasNextLine()) {
			String s= sc.nextLine(); // ���ڿ��� �Է¹޴´�.
			int size=s.length(); // ���ڿ��� ������ ��ŭ �ݺ�
			for(int j=0;j<size;j++) {
				char a=s.charAt(j); // ù��° ���Һ��� �ϳ��� ��������
				if(a==32) { //�ƽ�Ű �ڱ׈��� �̿��ؼ� ��,��,����, ������ �����Ѵ�.
					check[0]++;
				}else if(a>=65 && a<97) {
					check[1]++;
				}else if(a>=97) {
					check[2]++;
				}else if(a>=48 && a<58) {
					check[3]++;
				}
			}
			System.out.println(check[2]+" "+ check[1]+" "+check[3]+ " "+ check[0]);
			check[0]=0;
			check[1]=0;
			check[2]=0;
			check[3]=0;
			}
		}	
	}