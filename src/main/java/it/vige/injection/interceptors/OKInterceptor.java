package it.vige.injection.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class OKInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		return ic.proceed();
	}
}
