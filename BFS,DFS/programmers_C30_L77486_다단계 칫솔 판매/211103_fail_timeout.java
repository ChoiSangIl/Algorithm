import java.util.*;
class Solution {    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        //String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        //String[] seller = {"tod", "jaimie"};
        //int[] amount = {2, 1};

        int[] answer = new int[enroll.length];
        
        for(int i=0; i<seller.length; i++){
            dfs(enroll, referral, answer, seller[i], amount[i]*100);   
        }
        return answer;
    }
    
    public static void dfs(String[] enroll, String[] referral, int[] answer, String enrollName, int price){  
        if(price == 0 || enrollName.equals("-")){
            return;
        }
        
        for(int i=0; i<enroll.length; i++){
            double caculate = price * 0.1;
        
            if(enrollName.equals(enroll[i])){
                if(caculate < 1){
                    answer[i] = answer[i] + price;
                    return;
                }else{
                    int a = (int)caculate;
                    answer[i] = answer[i] + (price-(int)caculate);
                    dfs(enroll, referral, answer, referral[i], (int)caculate);   
                }
            }
        }
    }
}