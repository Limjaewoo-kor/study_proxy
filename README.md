Proxy의 주요기능은 크게 두가지로 구분할 수 있다.

1. 접근제어
- 권한에 따른 접근 차단
- 캐싱
- 지연 로딩

2.부가 기능의 추가
- 기존 기능 + 부가 기능을 더한다
- request나 response를 중간에 변형한다.
- 실행 시간을 측정하여 추가 로그를 남긴다.

GOF 디자인 패턴에서 이 두가지 경우를 의도에 따라 프록시 패턴과 데코레이터 패턴으로 나뉜다.

프록시패턴 - 접근제어가 목적

데코레이터 패턴 - 새로운 기능 추가가 목적

java Reflection 개념 정리 - 메서드 이름을 파라미터로 받아서 동적으로 메서드 지정 및 호출할 수 있는 기능 

JdkDynamicProxy_InvocationHandler_Filter(Patterns) - 동적 프록시 [ 인터페이스(Interface)가 있는 경우 프록시로 변환 하는법 ]
.getClass()호출시 sun.Proxy20 같은 식의 이름이 붙게된다.

CGLIB_MethodInterceptor - 동적 프록시 [ 인터페이스(Interface)가 없는 구체클래스(Impl)의 경우 프록시로 변환 하는법 ]
.getClass()호출시 Cglib. 같은 식의 이름이 붙게된다.

프록시를 생성할때는 new ProxyFactory를 이용한다.

Pointcut / Advice / Advisor

Pointcut은 filter 역할을 하며, 스프링에서 자체적으로 등록하는 프록시 빈의 경우 최초에 포인트컷으로 해당 클래스를 프록시로 등록할지 말지 판단할때 사용하며,
차후에 해당 구체 클래스 호출시에 클래스 내에서 각각의 메서드에 다시 한번 체크를 한다. 위에서 설명한 Proxy의 주요기능 중 접근제어의 역할을 한다고 볼 수 있다.

Advice는 위에서 설명한 Proxy의 주요기능 중 부가 기능 추가의 역할을 한다고 볼 수 있다.

Advisor는 Pointcut과 Advice를 합쳐서 하나의 Advisor되며, 

BeanPostProcessor를 implements 받은 뒤에 postProcessAfterInitialization 또는 postProcessBeforeInitialization 구현하면 프록시 빈 등록을 하지않고 advisor만 작성하여도 모두 프록시로 빈 등록을 할 수 있으며, advisor가 포함되기에 pointcut을 사용가능하기에 무엇을 프록시로 만들고 무엇을 만들지 않을지 모두 설정 할 수 있다.  


AutoProxyConfig / AspectJExpressionPointcut

실제로 실무의 스프링부트에서 많이 쓰이는 프록시 생성방법이며, 아래와 같이 사용된다.

AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
pointcut.setExpression("execution(* hello.proxy.app..*(..)) && !execution(* hello.proxy.app..noLog(..))"); 


- 인터페이스기반(V1)과 구체클래스기반(V2), 구체클래스기반_컴포넌트스캔(V3)에 각각 프록시 적용

