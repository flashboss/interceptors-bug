package it.vige.injection.interceptors;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * LoggingInterceptor binds to {@link @Logging} annotation, so methods or beans
 * which @Logging annotation is applied to, will be intercepted.
 *
 * @author Luca Stancapiano
 */
@Interceptor
public class OKInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		return ic.proceed();
	}
}
