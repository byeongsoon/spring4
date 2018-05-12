package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
    Greeter g1 = ctx.getBean("greeter",Greeter.class);
    Greeter g2 = ctx.getBean("greeter2", Greeter.class);

    String message = g1.greet("스프링");
    String message2 = g2.greet("장병순");
    System.out.println(message);
    System.out.println(message2);
  }
}
