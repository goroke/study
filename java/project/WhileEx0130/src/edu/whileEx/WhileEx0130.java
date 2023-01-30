package edu.whileEx;

public class WhileEx0130 {

	public static void main(String[] args) {
		int g[][] = new int[8][9];
		for(int i = 2; i <= 9; i++)
			for(int j = 1; j <= 9; j++)
				g[i-2][j-1] = i*j;

		for(int[] r : g)
			for (int c : r)
				System.out.print(c);
	
	}
	
}
