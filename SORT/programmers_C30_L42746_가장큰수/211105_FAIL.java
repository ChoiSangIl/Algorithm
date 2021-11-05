import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> array = new ArrayList<String>();
		String answer = "";
		
		List<BigNumber> list = new ArrayList<BigNumber>();
		for(int i=0; i<numbers.length; i++) {
			BigNumber big = new BigNumber(i, numbers[i], numbers[i]+"");
			list.add(big);
		}
		
		Collections.sort(list);
		for(BigNumber big : list) {
			answer = answer + big.number + "";
		}
        try {
            answer = Integer.parseInt(answer)+"";
        }catch(Exception e) {
            return answer;
        }
        
		return answer;
    }
    
    public static class BigNumber implements Comparable<BigNumber>  {
		Integer index;
		Integer number;
		Integer caculateNumber;

		public BigNumber(Integer index, Integer number, String caculateNumber) {
			this.index = index;
			this.number = number;
			this.caculateNumber = makeString(caculateNumber);
		}

		private Integer makeString(String target) {
			 switch (target.length()) {
	            case 1:
	            	target = target+target+target+target;
	            	break;
	            case 2:  
	            	target = target+target;
	            	break;
	            case 3:
	            	target = target+target.charAt(0);
	            	break;
	            default: break;
	        }
			
			return Integer.parseInt(target);
		}
		
		public Integer getCaculateNumber() {
			return caculateNumber;
		}


		public void setCaculateNumber(Integer caculateNumber) {
			this.caculateNumber = caculateNumber;
		}


		@Override
		public String toString() {
			return "BigNumber [index=" + index + ", number=" + number + ", caculateNumber=" + caculateNumber + "]";
		}

		@Override
		public int compareTo(BigNumber o) {
			// TODO Auto-generated method stub
			return o.getCaculateNumber() - getCaculateNumber();
		}
		
	}

}