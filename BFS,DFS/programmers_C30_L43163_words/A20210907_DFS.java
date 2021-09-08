import java.util.ArrayList;
import java.util.Arrays;

public class A20210907 {

	public static void main(String[] args) {
		String begin = "hit"; 
		String target  = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		ArrayList<String> stack = new ArrayList<String>();
		int result = dfs(begin, target, words, stack, 0);
		System.out.println(result);
	}
	
	public static int dfs (String begin, String target, String[] words, ArrayList<String> stack, int depth) {
		stack.add(begin);
		System.out.println(stack);
		
		if(begin.equals(target)) {
			stack.remove(begin);
			return depth;
		}
		
		int result = 0;
		
		for(int i=0; i<words.length; i++) {
			int wordCheck = 0;
			
			//��ȯ �������� üũ
			for(int j=0; j<words[i].length(); j++) {
				if(begin.charAt(j) == words[i].charAt(j)) {
					wordCheck = wordCheck + 1;
				}
			}
			
			//�ܾ� ��ȯ�� �����ϸ�, �ش� ��带 ���� Ž���Ѵ�.
			if(wordCheck == words[i].length()-1 && !stack.contains(words[i])) {
				int particleResult = dfs(words[i], target, words, stack, depth+1);
				if(result == 0) {
					result = particleResult;
				}else {
					if(particleResult != 0) {
						result = Math.min(result, particleResult);
					}
				}
			}
		}
		stack.remove(begin);
		return result;

	}

}
