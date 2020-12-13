package web.services.learn.lessons;

import io.swagger.models.auth.In;

public class Solution {

    public static void main(String[] args) {
        String result = strWithout3a3b(4,1);
        System.out.println(result);
    }
    public static String strWithout3a3b(int A, int B) {
        StringBuilder result = new StringBuilder();
        while(A>0 || B>0){
            boolean isA = false;
            int length = result.length();
            if(length >= 2 && result.charAt(length-2) == result.charAt(length-1)){
                if(result.charAt(length-1) == 'b'){
                    isA = true;
                }
            } else{
                if(A>B){
                    isA = true;
                }
            }
            if(isA){
                result.append("a");
                --A;
            } else {
                result.append("b");
                --B;
            }
        }
        return result.toString();
    }
}
