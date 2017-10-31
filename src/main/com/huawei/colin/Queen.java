package com.huawei.colin;

/**
 * 八皇后问题:回溯法与迭代法
 * @author Colin
 * @date 2017年6月16日上午12:43:51
 */
public class Queen {

	private static final int MAXQUEEN = 8;
	private static int[] cols = new int[MAXQUEEN + 1];	//cols[i] = k,标示第i列的皇后在第k行

	private static int num = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Queen().getArrangeMent2();
	}

	
	/**获取前n列的安排
	 * @param n
	 */
	public void getArrangeMent(int n) {
		boolean[] rows = new boolean[MAXQUEEN];
		
		for (int i = 0; i < n; i++) {
			rows[cols[i]] = true;
			int d = n - i;
			if (cols[i] - d >= 0) rows[cols[i] - d] = true;
			if (cols[i] + d <= MAXQUEEN - 1) rows[cols[i] + d] = true;
		}
		
		for (int i = 0; i < MAXQUEEN; i++) {
			if (rows[i]) continue;
			cols[n] = i;
			if (n < MAXQUEEN - 1) {
				getArrangeMent(n + 1);
			} else {
				num++;
				printChessBoard();
			}
		}
	}
	
	public static void printChessBoard() {
		System.out.println("第" + num + "种走法\n");
		for (int i = 1; i <= MAXQUEEN; i++) {
			for(int j = 1; j <= MAXQUEEN; j++) {
				if (i == cols[j]) {
					System.out.print("0");
				} else {
					System.out.print("+");
				}
			}
			System.out.println("");
		}
		
	}
	
	public void getArrangeMent2() {
		int t = 1;
		while (t > 0 && t <= MAXQUEEN) {
			boolean[] row = new boolean[MAXQUEEN + 1];
			for (int k = 1; k <= t - 1; k++) {
				row[cols[k]] = true;
				int d = t - k;
				if (cols[k] - d >= 0) row[cols[k] - d] = true;
				if (cols[k] + d <= MAXQUEEN) row[cols[k] + d] = true;
			}
			
			boolean fit = false;
			for (int i = cols[t] + 1; i <= MAXQUEEN; i++) {
				cols[t] = i;
				if (row[i]) {
					continue;
				}
				fit = true;
				if (t == MAXQUEEN) {
					num++;
					printChessBoard();
					break;
				} else {
					t++;
					cols[t] = 0;
					break;
				}
				
			}
			
			if (!fit){
				t--;
			}
		}
	}
}
