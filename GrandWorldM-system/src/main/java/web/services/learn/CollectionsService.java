package web.services.learn;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollectionsService {

    public static void main(String[] args) {
        PostfixExpression postfixExpression = new PostfixExpression();
        postfixExpression.add(6);
        postfixExpression.add(5);
        postfixExpression.add(2);
        postfixExpression.add(3);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(8);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.MULTIPLY);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(3);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.ADD);
        postfixExpression.add(PostfixExpression.FOUR_FUNCTIONS.MULTIPLY);
        double result = postfixExpression.getResult();
        System.out.println(result);
    }


        private void test(){
            System.out.println("sdds");
        }

}
