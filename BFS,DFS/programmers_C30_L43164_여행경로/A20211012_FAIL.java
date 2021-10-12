import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};
		
		
		
		Map<String, List<String>> ticketList = new HashMap<String, List<String>>();
		
		//티켓이 향하는 곳을 Map형태 데이터로 만듬
		for(String[] ticket : tickets) {
			if(!ticketList.containsKey(ticket[0])) {
				ArrayList<String> destination = new ArrayList<String>();
				destination.add(ticket[1]);
				ticketList.put(ticket[0], destination);
			}else {
				ticketList.get(ticket[0]).add(ticket[1]);
			}
		}
		
		System.out.println(ticketList);
		
		//목적지를 알파벳 순으로 sorting 하자.
		for(String key :ticketList.keySet()) {
			Collections.sort(ticketList.get(key));
		}
		
		System.out.println(ticketList);
		
		ArrayList<String> resultList = new ArrayList();
		resultList.add("ICN");
		detect(resultList, ticketList, "ICN");
		
		System.out.println(resultList);
		String[] answer = resultList.stream().toArray(String[]::new);
		System.out.println(answer);
	}
	
	static void detect(ArrayList<String> result, Map<String, List<String>> ticketList, String departStation) {
		if(ticketList.containsKey(departStation)) {
			List<String> destination = ticketList.get(departStation);
			
			if(!destination.isEmpty()) {
				String destStation = destination.get(0);
				result.add(destStation);
				destination.remove(0);
				detect(result, ticketList, destStation);
			}
		}
	}
	

}
