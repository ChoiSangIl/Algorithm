import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class A211015 {
    static ArrayList<String> result = new ArrayList<String>();
    
    public static void main(String[] args) {
    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	A211015 s = new A211015();
    	System.out.println(Arrays.toString(s.solution(tickets)));
    }
    
    public String[] solution(String[][] tickets) {
        Boolean[] visited = new Boolean[tickets.length];
		Arrays.fill(visited, Boolean.FALSE);
		dfs(visited, "ICN", "", tickets, 0);
        Collections.sort(result);
        
        String[] answer = result.get(0).split(",");
        return answer;
    }
    
    static void dfs(Boolean[] visited, String station, String path, String[][] tickets, int index)  {
		if("".equals(path)) {
			path = station;
		}else {
			path = path + ","+ station;
		}		
		
		if(index == tickets.length) {
			result.add(path);
		}
		
		
		for(int i=0; i<tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(station)) {
				visited[i] = true;
				dfs(visited, tickets[i][1], path, tickets, index+1);
				visited[i] = false;
			}
		}
	}
 
}