package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect2 {

  @Pointcut("execution(public * chap07..*(..))")
  private void publicTarget(){ }

  @Around("publicTarget()") // Around Advice를 지정할 때 사용
  public Object measure(ProceedingJoinPoint joinPoint) throws Throwable { // 공통 기능의 구현에 해당하는 함수
    long start = System.nanoTime();
    try {
      Object result = joinPoint.proceed();
      return result;
    } finally {
      long finish = System.nanoTime();
      Signature sig = joinPoint.getSignature();
      System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",joinPoint.getTarget().getClass().getSimpleName(),
          sig.getName(), Arrays.toString(joinPoint.getArgs()),(finish-start));
    }
  }
}
