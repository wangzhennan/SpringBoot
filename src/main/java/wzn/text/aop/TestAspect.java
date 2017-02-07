package wzn.text.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 导入spring-boot-starter-aop
 * AOP是spring核心内容 
 * AOP 面向切面编程，通过预编译方式和运行期动态代理实现功能的统一维护的技术。
 * AOP是一种思想 ，AOP是用横向抽取机制代理了原来纵向继承机制。
 * 预编译方式（AspectJ）
 * 动态代理分2种
 * JDK(实现InvocationHandler)
 * CJLIB(实现MethodInterceptor)
 * 如果类实现接口spring是用JDK,没有实现接口用CJLIB
 * @author wzn
 * @date 2017年2月7日下午2:51:27
 */
@Aspect
@Component
@Order(1)
public class TestAspect  {
	//@Order()注解来标识切面的优先级值 越小优先级越高
	 private Logger logger =  LoggerFactory.getLogger(this.getClass());
	 
	 @Pointcut("execution(public * wzn.text.aop.*.*(..))")
	 public void AspcetLog(){}
	 @Before("AspcetLog()")
	 public void before(JoinPoint joinPoint ){
		   logger.info("前置通知执行");
		   ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		   HttpServletRequest request = requestAttributes.getRequest();
		   Enumeration<String> parameterNames = request.getParameterNames();
		   while(parameterNames.hasMoreElements()){
			   String paraName = parameterNames.nextElement();
	            System.out.println("获取上送参数"+paraName+": "+request.getParameter(paraName)); 
		   }
	}
	 @AfterReturning("AspcetLog()")
	 public void afterReturning(JoinPoint joinPoint){
	        logger.info("后置通知执行");
	     }
}
