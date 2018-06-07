package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

public class ExeTimeAspect {

  public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.nanoTime();

    try {
      Object result = joinPoint.proceed();
      return result;
    } finally {
      long finish = System.nanoTime();
      Signature signature = joinPoint.getSignature();
      System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",joinPoint.getTarget().getClass().getSimpleName(),
          signature.getName(), Arrays.toString(joinPoint.getArgs()),(finish-start));
    }
  }
}
