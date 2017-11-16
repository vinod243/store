package com.nt.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogAroundAdvice  implements MethodInterceptor{
   private static Logger logger=Logger.getLogger(LogAroundAdvice.class);
   static{
	   PropertyConfigurator.configure("src/com/nt/commons/log4j.properties");
   }
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
	 Object retVal=null;
	 Object args[]=null;
		logger.debug("Entering into "+invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments()));
		args=invocation.getArguments();
		
	   //modify argument value
		if(((Float)args[0])<50000)
             args[1]=((Float)args[1])-0.5f;
		
		if(((Float)args[0])<=0 || ((Float)args[1])<=0 || ((Float)args[2])<=0){
			throw new IllegalArgumentException(" Invalid inputs are given....");
		}
		else{
		retVal=invocation.proceed();
		}
		
		retVal=((Float)retVal)+(((Float)retVal)*0.01f);
		logger.debug("Exiting from "+invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments()));
		return retVal;
	}
}
