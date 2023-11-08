package info.dmerej;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public Integer execute(final String values){
        List<String> tokens = Arrays.asList(values.split(" "));
        System.out.println("Tokens to computes : " + tokens);

        int a = Integer.valueOf(tokens.get(0));
        int b = Integer.valueOf(tokens.get(1));
        if("+".equals(tokens.get(2))) {
            return  a+b;
        }
        return 0;
    }
}
