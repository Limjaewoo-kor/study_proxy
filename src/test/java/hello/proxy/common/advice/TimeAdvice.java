package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        //프록시 팩토리에서 타겟을 넣어주기때문에 여기에선 필요없다
//        Object result = method.invoke(target, args); // 리플렛션을 사용해서 target 인스턴스의 메서드를 실행한다, args는 메서드 호출시 넘겨줄 인수.
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}",resultTime);
        return result;
    }
}
