import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
       List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(2);
		list2.add(4);
		list2.add(2);
		list2.add(5);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(3);
		list3.add(3);
		list3.add(1);
		list3.add(1);
		list3.add(2);
		list3.add(2);
		list3.add(4);
		list3.add(4);
		list3.add(5);
		list3.add(5);
		
		int[] score = new int[3];
		
		for(int i=0; i<answers.length; i++) {
			if(list1.get(i) == answers[i]) {
				score[0] = score[0]+1; 
			}
			if(list2.get(i) == answers[i]) {
				score[1] = score[1]+1; 
			}
			if(list3.get(i) == answers[i]) {
				score[2] = score[2]+1; 
			}
			list1.add(list1.get(i));
			list2.add(list2.get(i));
			list3.add(list3.get(i));
		}
		
		//System.out.println(Arrays.toString(score));
		int max = Math.max(score[2],Math.max(score[0], score[1]));
		
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 if(score[0] == max) list.add(1);
		 if(score[1] == max) list.add(2);
		 if(score[2] == max) list.add(3);
		 
		 int[] answer = new int[list.size()];
		 for(int i=0; i<list.size(); i++) {
			 answer[i] = list.get(i);
		 }
		
		 return answer;
    }
}