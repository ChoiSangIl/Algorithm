import java.util.*;
class Solution {    
    static Map<String,Integer> map = new HashMap();
    static Map<String,String> connect = new HashMap();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i],0);
            connect.put(enroll[i],referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            dfs(seller[i], amount[i]*100);   
        }
        
        for(int i=0; i<enroll.length; i++){
            answer[i] = map.get(enroll[i]);
        }
        
        
        return answer;
    }
    
    public static void dfs(String enrollName, int price){  
        if(price == 0 || enrollName.equals("-")){
            return;
        }
        
        double caculate = price * 0.1;
        
        if(caculate < 1){
            map.replace(enrollName,map.get(enrollName)+price);
            return;
        }else{
            int a = (int)caculate;
            map.replace(enrollName,map.get(enrollName)+(price-a));
            dfs(connect.get(enrollName), a);   
        }
       
    }
}