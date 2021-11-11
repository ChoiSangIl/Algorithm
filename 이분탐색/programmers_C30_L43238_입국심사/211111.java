import java.util.Arrays;

public class A211110 {

	public static void main(String[] args) {
		A211110 algo = new A211110();
		System.out.println(algo.solution(6, new int[] {7,10}));
	}
	
	
	public long solution(int n, int[] times) {
	    long answer = 0;
	    Arrays.sort(times);
	    
	    long left = 0;
	    long right = n * times[times.length-1];
	    
	    while(left<=right) {
	    	long sum =0;
	    	long mid = (left + right)/2;
	    	
	    	for(int i=0; i<times.length; i++ ) {
	    		sum = sum + mid/times[i];
	    	}
	    	
	    	if(n <= sum) {
	    		right = mid -1;
	    		answer = mid;
	    	}else {
	    		left = mid +1;
	    	}
	    }
	    
	    return answer;
	} 
}
