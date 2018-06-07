package main;

import chap07.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXmlOrder {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopOrder.xml");

    Calculator impeCal = ctx.getBean("impeCal", Calculator.class); // Calculator.class가 아닌 ImpeCalculator.class를 하면 익셉션
    long fivFact1 = impeCal.factorial(5);
    System.out.println("impeCal.factorial(5) = " + fivFact1);

    Calculator recCal = ctx.getBean("recCal", Calculator.class);
    long fiveFact2 = recCal.factorial(5);
    System.out.println("recCal.factorial(5) = " + fiveFact2);

    long fiveFact3 = recCal.factorial(5);
    System.out.println("recCal.factorial(5) = " + fiveFact3);

  }
}
