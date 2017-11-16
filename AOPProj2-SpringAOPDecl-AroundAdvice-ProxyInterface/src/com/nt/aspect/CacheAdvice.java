package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {
    private HashMap<String,Object>cache=new HashMap();
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=null;
		//get method and and args as key
		key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		if(!cache.containsKey(key)){
			retVal=invocation.proceed();
			cache.put(key,retVal);
		}
		else{
			System.out.println("From cache...");
			retVal=cache.get(key);
		}
		return retVal;
	}

}
