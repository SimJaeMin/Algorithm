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
			for (int a = 1; a < n; a++) { // ��
			
				if (data[i][a] == data[i][a + 1]) { // ���ε� �����Ŷ� ������
					if (a == n - 1) { // �׷��� a�� ������ ���� -> ���������� ����
						count++; // �� �ϳ� ã��
						
//						System.out.println("����");
//						for (int zz = 1; zz <= n; zz++) {
//							System.out.print(data[i][zz] + " ");
//						}
//						System.out.println();
						return; // ����
					} else {// �������� �ƴ�
						continue; // ��������
					}
				} else if (data[i][a] - data[i][a + 1] > 1 || data[i][a] - data[i][a + 1] < -1) {
					// ���δ� �� ��ġ�� ���̰� 1�� ���� ������� , �� �̻��̸� ����
					return;
				}else if(a==n-1){
					if(data[i][a] < data[i][a+1]) {
						if(check[i][a]==false) {
							check[i][a]=true;
//							System.out.println("����1111");
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
//							System.out.println("����2222");
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
				for (int a = 1; a < n; a++) { // ��
					//System.out.println("a : " + a );
					if (data[a][i] == data[a + 1][i]) { // ���ε� �����Ŷ� ������
						if (a == n - 1) { // �׷��� a�� ������ ���� -> ���������� ����
							count++; // �� �ϳ� ã��
//							System.out.println("a1 : " + a );
//							System.out.println("����");
//							for (int zz = 1; zz <= n; zz++) {
//								System.out.print(data[zz][i] + " ");
//							}
//							System.out.println();
							return; // ����
						} else {// �������� �ƴ�
							continue; // ��������
						}
					} else if (data[a][i] - data[a+1][i] > 1 || data[a][i] - data[a + 1][i] < -1) {
						// ���δ� �� ��ġ�� ���̰� 1�� ���� ������� , �� �̻��̸� ����
						return;
					}else if(a==n-1){
					//	System.out.println("a2 : " + a );
						if(data[a][i] < data[a + 1][i]) {
							if(check1[a][i]==false) {
								check1[a][i]=true;
//								System.out.println("����1111");
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
//							/	System.out.println("����2222");
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
			for (int a = 1; a < n; a++) { // ��
				if (data[i][a] == data[i][a + 1]) { // ���ε� �����Ŷ� ������
					if (a == n - 1) { // �׷��� a�� ������ ���� -> ���������� ����
						count++; // �� �ϳ� ã��
				
						return; // ����
					} else {// �������� �ƴ�
						continue; // ��������
					}
				} else if (data[i][a] - data[i][a + 1] > 1 || data[i][a] - data[i][a + 1] < -1) {
					// ���δ� �� ��ġ�� ���̰� 1�� ���� ������� , �� �̻��̸� ����
					return;
				} else { // ���ε� �����Ŷ� �����ʰ� ���̰� 1��
							// ���� ���� ���θ� ���� �� �����ϱ� ���� ���� ���� ã�´�.
					if (data[i][a] < data[i][a + 1]) { // ������ ����
						if (a < l) { // a<l �̶��Ŵ� ���θ� ����ִ� ���� ��ü�� �ȵȴٴ°�
							return; // �׷��� �׳� return;
						} else { // ���θ� ����ִ� ���̰��Ǹ�
							// ������ ���̸�ŭ ������ ���ڿ� �������� ���ؾߵ�
							for (int st = a - l + 1; st < a; st++) { // ���θ� ����� �� ���� ���̸�ŭ ���̰� ���ƾ���
								if (data[i][st] == data[i][st + 1]) {
									if (st == a - 1) { // ������ ���̸�ŭ ���̰� ������
										for (int xx = a - l + 1; xx <= a; xx++) {// ���θ� ���Ҵٰ� üũ���ֱ�
										
											if (check[i][xx] == false) {
												check[i][xx] = true; // ���θ� �������� üũ�� �������
											} else {
												return; // �̹� ���ΰ� ��������� ����
											}
										}
									
									}else {
										continue;
									}
								} else { // ���� ������ ���θ� ��������ϱ� return
									return;
								}
							}
						}

					} else { // ������ ���� -> �׷��� ���������� ���̰� l ������ ���̸�ŭ�� ���̰� �������� ���������
						if (a + l > n) { // ���������� ���̰� l �� ���θ� ��Ҵµ� �װ� ������ ���� n���� ũ�ٸ� �������
							return;
						} else { // ���θ� �� �� �ִ� ���̰� �Ǹ�
									// ������ ���� ��ŭ ���̰� ������ �����ָ��
							for (int st = a + 1; st < a + l; st++) { // ���������� ������ ���̸� ���� ���̸�ŭ ���̰� �������� ��
								if (data[i][st] == data[i][st + 1]) {
									if (st == a + l - 1) { // ������ ���̸�ŭ ���̰� ������
										for (int xx = a + 1; xx <= a + l; xx++) {
											if (check[i][xx] == false) {
												check[i][xx] = true; // ���θ� �������� üũ�� �������
											} else {
												return; // �̹� �������̸� �� ����
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
			for (int a = 1; a < n; a++) { // ��
				if (data[a][i] == data[a + 1][i]) { // ���ε� �����Ŷ� ������
					if (a == n - 1) { // �׷��� a�� ������ ���� -> ���������� ����
						count++; // �� �ϳ� ã��
				
						return; // ����
					} else {// �������� �ƴ�
						continue; // ��������
					}
				} else if (data[a][i] - data[a + 1][i] > 1 || data[a][i] - data[a + 1][i] < -1) {
					// ���δ� �� ��ġ�� ���̰� 1�� ���� ������� , �� �̻��̸� ����
					return;
				} else { // ���ε� �����Ŷ� �����ʰ� ���̰� 1��
							// ���� ���� ���θ� ���� �� �����ϱ� ���� ���� ���� ã�´�.
					if (data[a][i] < data[a + 1][i]) { // ������ ����
						if (a < l) { // a<l �̶��Ŵ� ���θ� ����ִ� ���� ��ü�� �ȵȴٴ°�
							return; // �׷��� �׳� return;
						} else { // ���θ� ����ִ� ���̰��Ǹ�
							// ������ ���̸�ŭ ������ ���ڿ� �������� ���ؾߵ�
							for (int st = a - l + 1; st < a; st++) { // ���θ� ����� �� ���� ���̸�ŭ ���̰� ���ƾ���
								if (data[st][i] == data[st + 1][i]) {
									if (st == a - 1) { // ������ ���̸�ŭ ���̰� ������
										for (int xx = a - l + 1; xx <= a; xx++) {// ���θ� ���Ҵٰ� üũ���ֱ�
											if (check1[xx][i] ==false) {
												check1[xx][i] = true; // ���θ� �������� üũ�� �������
											} else { // �̹� ���ΰ� ����ִ� ���¸� �ߺ��ؼ��� �ٽ� ���ϴϱ� return;
												return;
											}
										}
									
									}else {
										continue;
									}
								} else { // ���� ������ ���θ� ��������ϱ� return
									return;
								}
							}
						}

					} else { // ������ ���� -> �׷��� ���������� ���̰� l ������ ���̸�ŭ�� ���̰� �������� ���������
						if (a + l > n) { // ���������� ���̰� l �� ���θ� ��Ҵµ� �װ� ������ ���� n���� ũ�ٸ� �������
							return;
						} else { // ���θ� �� �� �ִ� ���̰� �Ǹ�
									// ������ ���� ��ŭ ���̰� ������ �����ָ��
							for (int st = a + 1; st < a + l; st++) { // ���������� ������ ���̸� ���� ���̸�ŭ ���̰� �������� ��
								if (data[st][i] == data[st + 1][i]) {
									if (st == a + l - 1) { // ������ ���̸�ŭ ���̰� ������
										for (int xx = a + 1; xx <= a + l; xx++) {
											if (check1[xx][i] == false) {
												check1[xx][i] = true; // ���θ� �������� üũ�� �������
											} else {
												return; // �̹� �������̸� �� ����
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
