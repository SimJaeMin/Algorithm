package kr.co.mlec.bf;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BF_3085 {
	static ArrayList<Character>[] a; // 2차원 배열을 위해 선언
	static int max = 1; // 가장 긴 같은 색 사탕의 갯수를 저장하기위해

	static int check(int n) {
		int count = 1; // 바꾼 상태에서 최대 길이를 찾을때 행,렬 2가지 기준으로  해야되서 
		int count2 = 1; // count 변수 2개선언
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					if (a[i].get(j) == a[i].get(j + 1)) { //자기와 오른쪽 원소를 비교해서
						count++; // 같으면 count 증가
						if (max < count) { // 그떄 max 값보다 커지면 max 값 교체
							max = count;
						}
					} else { // 다르면 count 는 그 떄 다시 시작이니까 1로설정
						count = 1;
					}
				}
				if (j + 1 < n) {
					if (a[j].get(i) == a[j + 1].get(i)) { // 자기 아래와 같은지비교
						count2++;
						if (max < count2) {
							max = count2;
						}
					} else {
						count2 = 1;
					}
				}
			}
			count = 1; //하나의 행,렬이 끝나면 다시 시작이니까 1로 초기화
			count2 = 1;
		}
 
		return max; // 최대값 리턴

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //초기 n 값을 입력받는다.
		int n = Integer.parseInt(br.readLine()); //초기 n 값을 입력받는다.
		int num; // 자기기준 오른쪽 및 아래와 바꾼 후 나온 최대값과 기존의 최대값을 비교하기위해
		int num1=1; // 자기기준 오른쪽 및 아래와 바꾼 후 나온 최대값과 기존의 최대값을 비교하기위해
		a = (ArrayList<Character>[]) new ArrayList[n]; // ArrayList[] 생성
		char temp; //swap 할 때 임시저장소
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Character>(); //각각의 ArrayList<Character> 생성
		}
		for (int i = 0; i < n; i++) { // 데이터입력
			String s = br.readLine(); // 한줄 입력받고
			for (int j = 0; j < n; j++) { // 문자열의 charAt 함수사용해서 하나씩 삽입
				a[i].add(s.charAt(j));
			}
		}
		for (int i = 0; i < n; i++) { // n*n 행렬이니까 n까지
			for (int j = 0; j < n; j++) { // 1행이든 1렬이든 n 까지 있으니
				if (j + 1 < n) { // 자기와 자기 다음꺼를 비교하는데 j가 n 까지 가버리면 범위를 초과하니까
					temp = a[i].get(j); //바꿀 대상 
					a[i].set(j, a[i].get(j + 1)); //바꿀 대상의 같은 행 오른쪽 원소
					a[i].set(j + 1, temp); // 바꾸기
					num=check(n); // 바꾼 상태에서 최대길이 찾기
					if(num1<num) { // 최대길이 찾은게 기존의 최대길이보다 길면 바꾸기
						num1=num;
					}
					
					temp = a[i].get(j); // 다시 원상복귀
					a[i].set(j, a[i].get(j + 1));
					a[i].set(j + 1, temp);
				
				
					temp=a[j].get(i); // 같은 과정인데 이거는 열
					a[j].set(i,a[j+1].get(i));
					a[j+1].set(i, temp);
					
					num=check(n);
					if(num1<num) {
						num1=num;
					}
					temp=a[j].get(i);
					a[j].set(i,a[j+1].get(i));
					a[j+1].set(i, temp);
			}
		}
	}
		System.out.println(num1);
}
}