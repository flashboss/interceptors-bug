package it.vige.injection.interceptors;

import javax.interceptor.Interceptors;

public class ItemServiceBean {

	@Interceptors({ OKInterceptor.class })
	public void ok() {
	}

	@NotOK
	public void notOk() {
	}

}
