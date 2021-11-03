import java.util.*;
class Solution {
    static ArrayList<Integer> numberList;
    static int[] number;
    static boolean[] visited;

    public int solution(String numbers) {
        number = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        numberList = new ArrayList<Integer>();

        for(int i=0; i<numbers.length(); i++){
            number[i] = numbers.charAt(i) - '0';
        }

        for(int i=0; i<number.length; i++){
         if(number[i] != 0){
             dfs(i, "");
         }   
        }

        int result = 0;
        for(int i=0; i<numberList.size(); i++){
            if(is_prime(numberList.get(i))){
                result ++;
            }
        }
        return result;
    }

    static void dfs(int index, String numbers){
        visited[index] = true;
        numbers = numbers + number[index];

        if(!numberList.contains(Integer.parseInt(numbers)))
        numberList.add(Integer.parseInt(numbers));

        for(int i=0; i<number.length; i++){
             if (!visited[i]){
                 dfs(i, numbers);
             }   
        }
        visited[index] = false;
    }


    public static boolean is_prime(int number) {
        if(number < 2) {
            return false;
        }

        if(number == 2) {
            return true;
        }

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}