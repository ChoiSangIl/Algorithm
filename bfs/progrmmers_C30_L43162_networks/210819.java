public class Algorithm_210819 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 3;
		int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
		int answer = 0;
		boolean[] path = new boolean[n];
		
		for(int i=0; i<n; i++) {
			path[i] = false;
		}
		
		for(int j=0; j<n; j++) {
			if(!path[j]) {
				answer ++;
				dfs(j, computers, path);
			}
		}
		
		System.out.println(answer);
	}
	
	
	public static void dfs(int index, int[][] computers, boolean[] path) {
		path[index] = true;
		
		for(int i=0; i<computers.length; i++) {
			if(path[i] == false && computers[index][i] == 1) {
				dfs(i, computers, path);
			}
		}
	}

}
