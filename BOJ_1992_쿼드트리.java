package solo.study;

import java.util.*;

public class BOJ_1992_쿼드트리 {
	
	public static int[][] img;		
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) {
    
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		img = new int[N][N];	
        
		for(int i = 0; i < N; i++) {
			String str = in.next();
			
			for(int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {
		if(isPossible(x, y, size)) {
			sb.append(img[x][y]);
			return;
		}
		
		int newSize = size / 2;	
		
		sb.append('(');	
		
		QuadTree(x, y, newSize);						// 왼쪽 위
		QuadTree(x, y + newSize, newSize);				// 오른쪽 위
		QuadTree(x + newSize, y, newSize);				// 왼쪽 아래
		QuadTree(x + newSize, y + newSize, newSize);	// 오른쪽 아래
		
		sb.append(')');	
			
	}
	
	public static boolean isPossible(int x, int y, int size) {
		int value = img[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
