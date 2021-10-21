import java.util.ArrayList;
import java.util.Scanner;

public class A211021_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int comCnt = sc.nextInt();
		int pairCnt = sc.nextInt();
		int pair[][] = new int [pairCnt][2];
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<pairCnt; i++) {
			for(int j=0; j<2; j++) {
				pair[i][j] = sc.nextInt();
			}
		}
		
		dfs(pair, 1, result);

		//System.out.println(result);
		System.out.println(result.size()-1);
	}
	
	public static void dfs(int pair[][], int index, ArrayList<Integer> result) {

		if(!result.contains(index)) result.add(index);
		
		for(int i=0; i<pair.length; i++) {
			if(pair[i][0] == index && !result.contains(pair[i][1])) {
				dfs(pair, pair[i][1], result);
			}
			
			if(pair[i][1] == index && !result.contains(pair[i][0])) {
				dfs(pair, pair[i][0], result);
			}
		}
		
	}
}
