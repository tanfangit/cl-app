package com.company.project.handler;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect  
@Component
public class LogAop {
		protected Logger logger = LoggerFactory.getLogger(getClass());
		@Autowired
		private  HttpServletRequest request;
		/** 
		   * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址, 
		   * 
		   * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？ 
		   * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 
		   * 
		   * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 
		   * 192.168.1.100 
		   * 
		   * 用户真实IP为： 192.168.1.110 
		   * 
		   * @param request 
		   * @return 
		   */ 
		  public  String getIpAddress(HttpServletRequest request) { 
		    String ip = request.getHeader("x-forwarded-for"); 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("Proxy-Client-IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("WL-Proxy-Client-IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_CLIENT_IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getRemoteAddr(); 
		    } 
		    return ip; 
		  } 
	    /**
	     * 定义一个切入点
	     */
	    @Pointcut("execution(* com.company.project.web.*.*(..))")
	    private void pointCutMethod() {
	    }
	    
	  
	    /**
	     *  声明前置通知
	     */
	   /* @Before("pointCutMethod()")
	    public void doBefore(JoinPoint point) {
	    String arg="";
	    	try {
	    	//Class classs =point.getTarget().getClass();
	    	String [] ParameterNames=((MethodSignature)point.getSignature()).getParameterNames();
	    	
	    	//拦截的放参数类型
	    	//Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
	    	//Class[] variableNames=((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
	   
	    	//拦截参数
	    	Object[] args = point.getArgs();
	    	 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder  
	                 .getRequestAttributes()).getRequest();
	    	
	    	  String requestUri = request.getRequestURI();  
	    	 logger.info("ip: "+getIpAddress(request)+" Being accessed:"+requestUri);    
	    	 arg="request paramete [";
	    	 for(int i=0;i<ParameterNames.length;i++){
	    		 String  ParameterName= ParameterNames[i];
	    		 String parameterArg=null==args[i]?"null":args[i].toString();
	    		
	    		if(i!=ParameterNames.length-1){
	    		arg+=ParameterName+":"+parameterArg+",";
	    		}else{
	    			arg+=ParameterName+":"+parameterArg+"]";
	    		}
	    	 }
	    	
	    	} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 logger.info(arg);
	    	
	    }*/

	    /**
	     *  声明后置通知
	     * @param result
	     */
	  /*  @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	    public void doAfterReturning(String result) {
	        System.out.println("后置通知");
	        System.out.println("---" + result + "---");
	    }*/

	    /**
	     *  声明例外通知
	     */
	/*    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	    public void doAfterThrowing(Exception e) {
	        System.out.println("例外通知");
	        System.out.println(e.getMessage());
	    }
*/
	    /**
	     *  声明最终通知
	     */
	  /*  @After("pointCutMethod()")
	    public void doAfter() {
	        System.out.println("最终通知");
	    }
*/
	    /**
	     *  声明环绕通知
	     * @param pjp
	     * @return
	     * @throws Throwable
	     */
	    @Around("pointCutMethod()")
	    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	    	 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder  
	                 .getRequestAttributes()).getRequest();
	    	 String arg="";
	     
	        String [] ParameterNames=((MethodSignature)pjp.getSignature()).getParameterNames();
	      //拦截参数
	    	Object[] args = pjp.getArgs();
	    	
	    	String requestUri = request.getRequestURI();  
	    	 logger.info("ip: "+getIpAddress(request)+" Being accessed:"+requestUri);   
	    	 String reqParameterStr ="{";
	 		Enumeration em = request.getParameterNames();
	 		 while (em.hasMoreElements()) {
	 		    String name = (String) em.nextElement();
	 		    String value = request.getParameter(name);
	 		    reqParameterStr +=name+":"+value+",";
	 		}
	 		 reqParameterStr = reqParameterStr.substring(0, reqParameterStr.length()-1)+"}";
	 		logger.info("reqParameterAll:"+reqParameterStr);
	    	 arg="request paramete [";
	    	 for(int i=0;i<ParameterNames.length;i++){
	    		 String  ParameterName= ParameterNames[i];
	    		 String parameterArg=null==args[i]?"null":args[i].toString();
	    		
	    		if(i!=ParameterNames.length-1){
	    		arg+=ParameterName+":"+parameterArg+",";
	    		}else{
	    			arg+=ParameterName+":"+parameterArg+"]";
	    		}
	    	 }
	    	 logger.info(arg); 
	     Object o = pjp.proceed();
    
    	
    	 
    	// System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
    	 String oStr=null==o?"":o.toString();
    	 String resultmsg="response result :"+oStr;
	        logger.info(resultmsg);
	        
	        return o;
	    }
}
