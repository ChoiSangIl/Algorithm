import java.util.Scanner;

public class A211019 {
	static int answer = Integer.MAX_VALUE;
	  
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] array = new int[n+2][m+2];
        boolean[][] visited = new boolean[n+2][m+2];

        for(int i = 1;i<=n;i++){
            String tmp = sc.next();
            for(int j = 1;j<=m;j++){
            	array[i][j] = tmp.charAt(j-1) - '0';
            }
        }
		
		for(int i=0; i<n+2; i++){
			 for(int j=0; j<m+2; j++) { 
				 System.out.print(array[i][j]); 
			 }
			 System.out.println(""); 
		}
    	
    	dfs(n,m,1,1,visited,array,0);
    	System.out.println(answer);
        
	}
	
	public static void dfs(int destinationX, int destinationY, int x, int y, boolean[][] visited, int[][] array, int result) {
		result = result + 1;
		int[] search = {0,-1,0,1,1,0,-1,0};
		
		if(destinationX == x && destinationY == y) {
			answer = Math.min(answer, result);
			visited[x][y] = false;
			result = result -1;
			return;
		}
		
		visited[x][y] = true;
		for(int i=0; i<search.length; i=i+2) {
			int searchX = x + search[i];
			int searchY = y + search[i+1];
			if(!visited[searchX][searchY] && array[searchX][searchY] == 1) {
				//System.out.println(searchX + "_" + searchY);
				dfs(destinationX, destinationY, searchX, searchY, visited, array, result);
			}
		}

		visited[x][y] = false;
		result = result -1;
	}
}