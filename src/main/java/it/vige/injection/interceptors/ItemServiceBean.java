package it.vige.injection.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class ItemServiceBean {

	@Interceptors({ OKInterceptor.class })
	public void ok() {
	}

	@Interceptors({ NotOKInterceptor.class })
	public void notOk() {
	}

}
