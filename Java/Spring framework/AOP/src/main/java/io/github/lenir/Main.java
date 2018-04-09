package io.github.lenir;

import io.github.lenir.loggable.Bacon;
import io.github.lenir.loggable.Spam;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        System.out.println(":: AOP, Aspect Oriented Programming Tutorial");

        String applicationConfigLoc = "classpath:applicationCTX.xml";
        AbstractApplicationContext context = new GenericXmlApplicationContext(applicationConfigLoc);

        Spam spam = context.getBean("spam", Spam.class);
        Bacon bacon = context.getBean("bacon", Bacon.class);
        Egg egg = context.getBean("egg", Egg.class);

        System.out.println(":: In Loggable package where logger's pointcut");
        spam.spamSong();
        bacon.baconSong();
        System.out.println(":: Outside of Loggable package. No loggings.");
        egg.eggSong();

        context.close();



    }
}
