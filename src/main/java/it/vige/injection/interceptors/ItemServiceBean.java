package it.vige.injection.interceptors;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class ItemServiceBean {

	@OK
	public void create() {
	}

	@Interceptors({ NotOKInterceptor.class })
	public void getExcludedList() {
	}

}
