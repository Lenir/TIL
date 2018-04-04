import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args){

        String configLocation = "classpath:applicationCTX.xml";

        AbstractApplicationContext context = new GenericXmlApplicationContext(configLocation);
        Calculator calc = context.getBean("calc", Calculator.class);

        System.out.println("4 + 2 = " + calc.add());

    }
}
