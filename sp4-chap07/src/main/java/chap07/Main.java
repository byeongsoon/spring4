package chap07;

public class Main {
  public static void main(String[] args) {

    ImpeCalculator impeCalculator = new ImpeCalculator();
    long start1 = System.currentTimeMillis();
    long fourFactorial1 = impeCalculator.factorial(4);
    long end1 = System.currentTimeMillis();
    System.out.printf("ImpeCalculator.factorial(4) 실행 시간 = %d\n",(end1-start1));

    RecCalculator recCalculator = new RecCalculator();
    long start2 = System.currentTimeMillis();
    long fourFactorial2 = recCalculator.factorial(4);
    long end2 = System.currentTimeMillis();
    System.out.printf("RecCalculator.factorial(4) 실행 시간 = %d\n",(end2 - start2));

    ImpeCalculator impeCalculator2 = new ImpeCalculator();
    ExeTimeCalculator exeTimeCalculator = new ExeTimeCalculator(impeCalculator2);
    long result = exeTimeCalculator.factorial(4);


  }
}
