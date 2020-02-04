package kr.co.mlec.simul;

import java.util.Scanner;

public class Simul_14890 {
	static int count = 0;
	static int n;
	static int l;
	static int data[][];
	static boolean check1[][];
	static boolean check[][];

	public static void start(int i, int j, int jud) {
		if(l==1) {
			if(jud==0) {
			check = new boolean[n + 1][n + 1];
			for (int a = 1; a < n; a++) { // 열
			
				if (data[i][a] == data[i][a + 1]) { // 열인데 다음거랑 같으면
					if (a == n - 1) { // 그런데 a가 마지막 전꺼 -> 마지막까지 같다
						count++; // 길 하나 찾음
						
//						System.out.println("가로");
//						for (int zz = 1; zz <= n; zz++) {
//							System.out.print(data[i][zz] + " ");
//						}
//						System.out.println();
						return; // 리턴
					} else {// 마지막은 아님
						continue; // 다음꺼비교
					}
				} else if (data[i][a] - data[i][a + 1] > 1 || data[i][a] - data[i][a + 1] < -1) {
					// 경사로는 두 위치의 차이가 1일 때만 깔수있음 , 그 이상이면 못함
					return;
				}else if(a==n-1){
					if(data[i][a] < data[i][a+1]) {
						if(check[i][a]==false) {
							check[i][a]=true;
//							System.out.println("가로1111");
//							for (int zz = 1; zz <= n; zz++) {
//								System.out.print(data[i][zz] + " ");
//							}
//							System.out.println();
							count++;
							return;
						}else {
							return;
						}
					}else {
						if(check[i][a+1]==false) {
							check[i][a+1]=true;
//							System.out.println("가로2222");
//							for (int zz = 1; zz <= n; zz++) {
//								System.out.print(data[i][zz] + " ");
//							}
//							System.out.println();
							count++;
							return;
						}else {
							return;
						}
					}
				}else {
					if(data[i][a] < data[i][a+1]) {
						if(check[i][a]==false) {
							check[i][a]=true;
						}else {
							return;
						}
					}else {
						if(check[i][a+1]==false) {
							check[i][a+1]=true;
						}else {
							return;
						}
					}
				}
			}
			}
			
			if(jud==1) {
				check1 = new boolean[n + 1][n + 1];
				for (int a = 1; a < n; a++) { // 열
					//System.out.println("a : " + a );
					if (data[a][i] == data[a + 1][i]) { // 열인데 다음거랑 같으면
						if (a == n - 1) { // 그런데 a가 마지막 전꺼 -> 마지막까지 같다
							count++; // 길 하나 찾음
//							System.out.println("a1 : " + a );
//							System.out.println("세로");
//							for (int zz = 1; zz <= n; zz++) {
//								System.out.print(data[zz][i] + " ");
//							}
//							System.out.println();
							return; // 리턴
						} else {// 마지막은 아님
							continue; // 다음꺼비교
						}
					} else if (data[a][i] - data[a+1][i] > 1 || data[a][i] - data[a + 1][i] < -1) {
						// 경사로는 두 위치의 차이가 1일 때만 깔수있음 , 그 이상이면 못함
						return;
					}else if(a==n-1){
					//	System.out.println("a2 : " + a );
						if(data[a][i] < data[a + 1][i]) {
							if(check1[a][i]==false) {
								check1[a][i]=true;
//								System.out.println("세로1111");
//								for (int zz = 1; zz <= n; zz++) {
//									System.out.print(data[zz][i] + " ");
//								}
//								System.out.println();
								count++;
								return;
							}else {
								return;
							}
						}else {
							if(check1[a + 1][i]==false) {
								check1[a + 1][i]=true;
//							/	System.out.println("세로2222");
//								for (int zz = 1; zz <= n; zz++) {
//									System.out.print(data[zz][i] + " ");
//								}
//								System.out.println();
								count++;
								return;
							}else {
								return;
							}
						}
					}else {
						if(data[a][i] < data[a + 1][i]) {
					//		System.out.println("a3 : " + a );
							if(check1[a][i]==false) {
								check1[a][i]=true;
							}else {
								return;
							}
						}else {
//							System.out.println("a4 : " + a );
//							System.out.println(check[a+1][i]);
							if(check1[a + 1][i]==false) {
								check1[a + 1][i]=true;
							}else {
								return;
							}
						}
					}
				}
		}
			return;
		}
		if (jud == 0) {
			check = new boolean[n + 1][n + 1];
			for (int a = 1; a < n; a++) { // 열
				if (data[i][a] == data[i][a + 1]) { // 열인데 다음거랑 같으면
					if (a == n - 1) { // 그런데 a가 마지막 전꺼 -> 마지막까지 같다
						count++; // 길 하나 찾음
				
						return; // 리턴
					} else {// 마지막은 아님
						continue; // 다음꺼비교
					}
				} else if (data[i][a] - data[i][a + 1] > 1 || data[i][a] - data[i][a + 1] < -1) {
					// 경사로는 두 위치의 차이가 1일 때만 깔수있음 , 그 이상이면 못함
					return;
				} else { // 열인데 다음거랑 같지않고 차이가 1임
							// 작은 값에 경사로를 놓을 수 있으니까 둘중 작은 값을 찾는다.
					if (data[i][a] < data[i][a + 1]) { // 이전깨 작음
						if (a < l) { // a<l 이란거는 경사로를 깔수있는 길이 자체가 안된다는거
							return; // 그러면 그냥 return;
						} else { // 경사로를 깔수있는 길이가되면
							// 경사로의 길이만큼 그전의 숫자와 같은지를 비교해야됨
							for (int st = a - l + 1; st < a; st++) { // 경사로를 깔려면 그 경사로 길이만큼 높이가 같아야함
								if (data[i][st] == data[i][st + 1]) {
									if (st == a - 1) { // 경사로의 길이만큼 높이가 같으면
										for (int xx = a - l + 1; xx <= a; xx++) {// 경사로를 놓았다고 체크해주기
										
											if (check[i][xx] == false) {
												check[i][xx] = true; // 경사로를 놓은곳임 체크를 해줘야함
											} else {
												return; // 이미 경사로가 깔려있으면 리턴
											}
										}
									
									}else {
										continue;
									}
								} else { // 같지 않으면 경사로를 깔수없으니까 return
									return;
								}
							}
						}

					} else { // 다음깨 작음 -> 그러면 다음꺼부터 길이가 l 경사로의 길이만큼이 높이가 같은지를 비교해줘야함
						if (a + l > n) { // 다음꺼부터 길이가 l 인 경사로를 깔았는데 그게 기존의 길이 n보다 크다면 깔수없음
							return;
						} else { // 경사로를 깔 수 있는 길이가 되면
									// 경사로의 길이 만큼 높이가 같은지 비교해주면됨
							for (int st = a + 1; st < a + l; st++) { // 다음꺼부터 경사로의 길이를 더한 길이만큼 높이가 같은지를 비교
								if (data[i][st] == data[i][st + 1]) {
									if (st == a + l - 1) { // 경사로의 길이만큼 높이가 같으면
										for (int xx = a + 1; xx <= a + l; xx++) {
											if (check[i][xx] == false) {
												check[i][xx] = true; // 경사로를 놓은곳임 체크를 해줘야함
											} else {
												return; // 이미 놓은곳이면 또 못함
											}
												
										}
									
									}
								} else {
									return;
								}
							}
						}
					}
				}
			}
		}
		if (jud == 1) {
			check1 = new boolean[n + 1][n + 1];
			for (int a = 1; a < n; a++) { // 열
				if (data[a][i] == data[a + 1][i]) { // 열인데 다음거랑 같으면
					if (a == n - 1) { // 그런데 a가 마지막 전꺼 -> 마지막까지 같다
						count++; // 길 하나 찾음
				
						return; // 리턴
					} else {// 마지막은 아님
						continue; // 다음꺼비교
					}
				} else if (data[a][i] - data[a + 1][i] > 1 || data[a][i] - data[a + 1][i] < -1) {
					// 경사로는 두 위치의 차이가 1일 때만 깔수있음 , 그 이상이면 못함
					return;
				} else { // 열인데 다음거랑 같지않고 차이가 1임
							// 작은 값에 경사로를 놓을 수 있으니까 둘중 작은 값을 찾는다.
					if (data[a][i] < data[a + 1][i]) { // 이전깨 작음
						if (a < l) { // a<l 이란거는 경사로를 깔수있는 길이 자체가 안된다는거
							return; // 그러면 그냥 return;
						} else { // 경사로를 깔수있는 길이가되면
							// 경사로의 길이만큼 그전의 숫자와 같은지를 비교해야됨
							for (int st = a - l + 1; st < a; st++) { // 경사로를 깔려면 그 경사로 길이만큼 높이가 같아야함
								if (data[st][i] == data[st + 1][i]) {
									if (st == a - 1) { // 경사로의 길이만큼 높이가 같으면
										for (int xx = a - l + 1; xx <= a; xx++) {// 경사로를 놓았다고 체크해주기
											if (check1[xx][i] ==false) {
												check1[xx][i] = true; // 경사로를 놓은곳임 체크를 해줘야함
											} else { // 이미 경사로가 깔려있는 상태면 중복해서는 다시 못하니까 return;
												return;
											}
										}
									
									}else {
										continue;
									}
								} else { // 같지 않으면 경사로를 깔수없으니까 return
									return;
								}
							}
						}

					} else { // 다음깨 작음 -> 그러면 다음꺼부터 길이가 l 경사로의 길이만큼이 높이가 같은지를 비교해줘야함
						if (a + l > n) { // 다음꺼부터 길이가 l 인 경사로를 깔았는데 그게 기존의 길이 n보다 크다면 깔수없음
							return;
						} else { // 경사로를 깔 수 있는 길이가 되면
									// 경사로의 길이 만큼 높이가 같은지 비교해주면됨
							for (int st = a + 1; st < a + l; st++) { // 다음꺼부터 경사로의 길이를 더한 길이만큼 높이가 같은지를 비교
								if (data[st][i] == data[st + 1][i]) {
									if (st == a + l - 1) { // 경사로의 길이만큼 높이가 같으면
										for (int xx = a + 1; xx <= a + l; xx++) {
											if (check1[xx][i] == false) {
												check1[xx][i] = true; // 경사로를 놓은곳임 체크를 해줘야함
											} else {
												return; // 이미 놓은곳이면 또 못함
											}
										}
								
									}
								} else {
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		data = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				data[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {

			start(i, 0, 0);
			start(i, 0, 1);
		}
		System.out.println(count);

	}
}
