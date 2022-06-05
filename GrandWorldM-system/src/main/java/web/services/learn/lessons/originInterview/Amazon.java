package web.services.learn.lessons.originInterview;

/**
 * 亚马逊一面面试题
 *
 * @author HeTing.Zhao
 * @since 2022/6/5
 */
public class Amazon {

    //123->YiBaiErShiSan
//10000->YiWan
//10001->YiWanLingYi
//1230000->YiBaiErShiSanWan
//10 -> YiShi
// -123 -> FuYiBaiErShiSan
//1,2345,6789 ->
//input: int32 [-2.1B, 2.1B], output: string


    private static final String[] NUMBERS = {"ling","yi","er",};
    private static final String[] DIGITS = {"ge","shi","bai",};

    public String solution(int num){
        String numsStr = String.valueOf(num);
        int len = numsStr.length();
        int index = len - 1;
        int segment  = 0;
        StringBuilder s = new StringBuilder();
        if(numsStr.charAt(0) == '-'){
            s.append("fu");
        }
        while(index >= 0){
            //validate index.
            String currentStr = "";
            if(index - 4 < 0){
                currentStr = numsStr.substring(0, index);
            } else {
                currentStr = numsStr.substring(index - 4, index);
            }
            int lenOfcurrentStr = currentStr.length();
            for(int i = 0; i < lenOfcurrentStr; ++i){
                int currentNum = currentStr.charAt(i) - '0';
                if((currentStr.charAt(i-1) - '0') == 0 && currentNum == 0){
                    s.append(NUMBERS[0]);
                }
                s.append(NUMBERS[currentNum]);
                String digit = DIGITS[lenOfcurrentStr - i - 1];
                s.append(digit);
            }
            if(segment > 0){
                s.append(NUMBERS[segment]);
            }
            if(index < 4){
                index = 0;
            }else {
                index -= index - 4;
            }
            ++segment;
        }
        return s.toString();
    }
}
