package it.vige.injection.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class SimpleService {

	@Interceptors({ OKInterceptor.class })
	public void ok() {
	}

	@NotOK
	public void notOk() {
	}

}
